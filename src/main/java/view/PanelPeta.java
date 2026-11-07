package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import util.TemaJetExpress;


public class PanelPeta extends JPanel {

    @FunctionalInterface
    public interface PendengarKoordinat {
        void koordinatTerpilih(BigDecimal latitude,
                BigDecimal longitude);
    }

    private static final GeoPosition SAMARINDA =
            new GeoPosition(-0.4948, 117.1446);

    private static final int ZOOM_AWAL = 12;
    private static final int ZOOM_MIN = 3;
    private static final int ZOOM_MAKS = 17;

    private final JXMapViewer mapViewer = new JXMapViewer();
    private final JLabel labelKoordinat = new JLabel(
            "Klik atau geser peta untuk memilih titik tujuan");
    private final JButton tombolPerbesar = new JButton("+");
    private final JButton tombolPerkecil = new JButton("-");
    private final JButton tombolPusatkan = new JButton("Pusatkan");

    private GeoPosition posisiMarker;
    private PendengarKoordinat pendengar;

    private Point titikTekan;
    private GeoPosition pusatSaatTekan;
    
    private boolean modeLihatSaja = false;



    public PanelPeta() {
        setLayout(new BorderLayout(0, 0));
        setBorder(BorderFactory.createLineBorder(
                TemaJetExpress.GARIS, 1, true));

        TileFactoryInfo info = new OSMTileFactoryInfo(
                "OpenStreetMap", "https://tile.openstreetmap.org");
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        tileFactory.setThreadPoolSize(4);
        mapViewer.setTileFactory(tileFactory);
        mapViewer.setZoom(ZOOM_AWAL);
        mapViewer.setCenterPosition(SAMARINDA);
        mapViewer.setPanEnabled(false); 
        mapViewer.setOverlayPainter(pewarnaPin());

        MouseAdapter interaksi;
        interaksi = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (mapViewer.getTileFactory() == null) {
                    return;
            }

                 if (e.getButton() == MouseEvent.BUTTON1) {
                 if (!modeLihatSaja) {
                        pilihTitik(e.getPoint());
            }
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                 titikTekan = e.getPoint();
                 pusatSaatTekan = mapViewer.getCenterPosition();
                }
            }

@Override
public void mouseDragged(MouseEvent e) {
    if (mapViewer.getTileFactory() == null) {
        return;
    }

    if (titikTekan != null
            && pusatSaatTekan != null
            && (e.getModifiersEx()
                    & MouseEvent.BUTTON3_DOWN_MASK) != 0) {
        geserPeta(e.getPoint());
    } else if (!modeLihatSaja
            && (e.getModifiersEx()
                    & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
        pilihTitik(e.getPoint());
    }
}
            
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    titikTekan = null;
                    pusatSaatTekan = null;
                }
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int zoom = mapViewer.getZoom()
                        + e.getWheelRotation();
                mapViewer.setZoom(Math.max(ZOOM_MIN,
                        Math.min(ZOOM_MAKS, zoom)));
            }
        };
        mapViewer.addMouseListener(interaksi);
        mapViewer.addMouseMotionListener(interaksi);
        mapViewer.addMouseWheelListener(interaksi);
        add(mapViewer, BorderLayout.CENTER);

        JPanel bilahBawah = new JPanel(new BorderLayout(8, 0));
        bilahBawah.setBackground(TemaJetExpress.PUTIH);
        bilahBawah.setBorder(BorderFactory.createEmptyBorder(
                6, 10, 6, 10));

        labelKoordinat.setFont(new Font("Segoe UI", 1, 12));
        labelKoordinat.setForeground(TemaJetExpress.TEBAS);
        bilahBawah.add(labelKoordinat, BorderLayout.CENTER);

        JPanel panelTombol = new JPanel(new FlowLayout(
                FlowLayout.RIGHT, 6, 0));
        panelTombol.setOpaque(false);

        for (JButton tombol : new JButton[]{tombolPerbesar,
                tombolPerkecil, tombolPusatkan}) {
            tombol.setFont(new Font("Segoe UI", 1, 12));
            tombol.setFocusPainted(false);
            tombol.setBackground(TemaJetExpress.BIRU);
            tombol.setForeground(Color.WHITE);
            tombol.setBorder(BorderFactory.createEmptyBorder(
                    4, 12, 4, 12));
            tombol.setCursor(java.awt.Cursor.getPredefinedCursor(
                    java.awt.Cursor.HAND_CURSOR));
            panelTombol.add(tombol);
        }

        tombolPerbesar.addActionListener(e -> ubahZoom(1));
        tombolPerkecil.addActionListener(e -> ubahZoom(-1));
        tombolPusatkan.addActionListener(e -> pusatkanKeMarker());

        bilahBawah.add(panelTombol, BorderLayout.EAST);
        add(bilahBawah, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(420, 320));
        setMinimumSize(new Dimension(300, 240));
    }

    public void saatKoordinatBerubah(PendengarKoordinat pendengar) {
        this.pendengar = pendengar;
    }
    
public void setModeLihatSaja(boolean aktif) {
    this.modeLihatSaja = aktif;
}
    public void setPosisi(BigDecimal latitude, BigDecimal longitude) {
        if (latitude == null || longitude == null) {
            posisiMarker = null;
            labelKoordinat.setText(
                    "Klik atau geser peta untuk memilih titik tujuan");
            mapViewer.repaint();
            return;
        }
        posisiMarker = new GeoPosition(latitude.doubleValue(),
                longitude.doubleValue());
        perbaruiLabel();
        mapViewer.setCenterPosition(posisiMarker);
        mapViewer.repaint();
    }

    public BigDecimal getLatitude() {
        return posisiMarker == null ? null
                : bulatkan(posisiMarker.getLatitude());
    }

    public BigDecimal getLongitude() {
        return posisiMarker == null ? null
                : bulatkan(posisiMarker.getLongitude());
    }

    public void resetKeSamarinda() {
        posisiMarker = null;
        labelKoordinat.setText(
                "Klik atau geser peta untuk memilih titik tujuan");
        mapViewer.setCenterPosition(SAMARINDA);
        mapViewer.setZoom(ZOOM_AWAL);
        mapViewer.repaint();
        if (pendengar != null) {
            pendengar.koordinatTerpilih(null, null);
        }
    }

    private void pilihTitik(Point titik) {
        GeoPosition posisi = mapViewer.convertPointToGeoPosition(titik);
        if (posisi == null) {
            return;
        }
        posisiMarker = posisi;
        perbaruiLabel();
        mapViewer.repaint();
        if (pendengar != null) {
            pendengar.koordinatTerpilih(getLatitude(), getLongitude());
        }
    }

    private void geserPeta(Point titikSekarang) {
        if (titikTekan == null || pusatSaatTekan == null) {
            return;
        }
        int dx = titikSekarang.x - titikTekan.x;
        int dy = titikSekarang.y - titikTekan.y;
        Point2D pusatPiksel =
                mapViewer.convertGeoPositionToPoint(pusatSaatTekan);
        Point2D pusatBaru = new Point2D.Double(
                pusatPiksel.getX() - dx, pusatPiksel.getY() - dy);
        GeoPosition posisiBaru =
                mapViewer.convertPointToGeoPosition(pusatBaru);
        if (posisiBaru != null) {
            mapViewer.setCenterPosition(posisiBaru);
        }
    }

    private void perbaruiLabel() {
        if (posisiMarker == null) {
            return;
        }
        labelKoordinat.setText("Titik tujuan →  Latitude: "
                + getLatitude().toPlainString()
                + "   |   Longitude: "
                + getLongitude().toPlainString());
    }

    private void ubahZoom(int delta) {
        int zoom = mapViewer.getZoom() - delta;
        mapViewer.setZoom(Math.max(ZOOM_MIN,
                Math.min(ZOOM_MAKS, zoom)));
    }

    private void pusatkanKeMarker() {
        if (posisiMarker != null) {
            mapViewer.setCenterPosition(posisiMarker);
        } else {
            mapViewer.setCenterPosition(SAMARINDA);
        }
    }

    private org.jxmapviewer.painter.Painter<JXMapViewer> pewarnaPin() {
        return (Graphics2D g, JXMapViewer peta, int lebar, int tinggi) -> {
            if (posisiMarker == null) {
                return;
            }
            g = (Graphics2D) g.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            Point2D titik =
                    peta.convertGeoPositionToPoint(posisiMarker);
            double x = titik.getX();
            double y = titik.getY();

            // Cincin luar transparan
            g.setColor(new Color(255, 102, 0, 70));
            g.fill(new Ellipse2D.Double(x - 16, y - 16, 32, 32));

            // Badan pin
            g.setColor(TemaJetExpress.ORANYE);
            g.fill(new Ellipse2D.Double(x - 9, y - 9, 18, 18));
            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(2.4f));
            g.draw(new Ellipse2D.Double(x - 9, y - 9, 18, 18));

            // Titik pusat putih
            g.setColor(Color.WHITE);
            g.fill(new Ellipse2D.Double(x - 3, y - 3, 6, 6));

            g.dispose();
        };
    }

    private static BigDecimal bulatkan(double nilai) {
        return BigDecimal.valueOf(nilai).setScale(8, RoundingMode.HALF_UP);
    }
}
