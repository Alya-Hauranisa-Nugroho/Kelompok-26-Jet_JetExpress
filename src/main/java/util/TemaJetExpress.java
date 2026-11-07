package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public final class TemaJetExpress {

    public static final Color ORANYE = new Color(255, 102, 0);
    public static final Color ORANYE_TUAH = new Color(219, 84, 0);
    public static final Color BIRU = new Color(0, 51, 153);
    public static final Color BIRU_TUAH = new Color(0, 38, 115);
    public static final Color MERAH = new Color(204, 51, 51);
    public static final Color MERAH_TUAH = new Color(168, 38, 38);
    public static final Color HIJAU = new Color(0, 145, 74);
    public static final Color LATAR = new Color(244, 246, 250);
    public static final Color LATAR_SEKUNDER = new Color(232, 236, 244);
    public static final Color PUTIH = Color.WHITE;
    public static final Color TEBAS = new Color(45, 45, 45);
    public static final Color ABU_TEKS = new Color(110, 110, 110);
    public static final Color GARIS = new Color(206, 212, 222);

    private static final Font FONT_NORMAL = new Font("Segoe UI", 0, 12);
    private static final Font FONT_TEbal = new Font("Segoe UI", 1, 12);

    private TemaJetExpress() {
    }

    public static void terapkanTema(JPanel panel) {
        if (panel == null) {
            return;
        }
        gayaPanel(panel, panel.getName());
        susun(panel);
    }

    private static void susun(Component induk) {
        if (induk instanceof JPanel panelAnak) {
            gayaPanel(panelAnak, panelAnak.getName());
        } else if (induk instanceof JButton tombol) {
            gayaTombol(tombol);
        } else if (induk instanceof JTextField teks) {
            gayaInput(teks);
        } else if (induk instanceof JTextArea area) {
            gayaInput(area);
        } else if (induk instanceof JPasswordField sandi) {
            gayaInput(sandi);
        } else if (induk instanceof JComboBox<?> combo) {
            gayaCombo(combo);
        } else if (induk instanceof JSpinner spinner) {
            gayaSpinner(spinner);
        } else if (induk instanceof JTable tabel) {
            gayaTabel(tabel);
        } else if (induk instanceof JLabel label) {
            gayaLabel(label);
        }

        if (induk instanceof java.awt.Container wadah) {
            for (Component anak : wadah.getComponents()) {
                susun(anak);
            }
        }
    }

    private static void gayaPanel(JPanel panel, String nama) {
        if (nama == null) {
            return;
        }
        String n = nama.toLowerCase();

        if (n.startsWith("pmenu") || n.startsWith("plogo")
                || n.startsWith("panellogo") || n.equals("logo")) {
            panel.setBackground(BIRU);
        }
    }

    public static void gayaTombol(JButton tombol) {
        String nama = tombol.getName() == null
                ? "" : tombol.getName().toLowerCase();

        Color dasar;
        Color tekan;
        if (nama.contains("batal") || nama.contains("hapus")
                || nama.contains("keluar") || nama.contains("logout")) {
            dasar = MERAH;
            tekan = MERAH_TUAH;
        } else if (nama.contains("kembali") || nama.contains("cari")
                || nama.contains("reset") || nama.contains("refresh")) {
            dasar = BIRU;
            tekan = BIRU_TUAH;
        } else {
            dasar = ORANYE;
            tekan = ORANYE_TUAH;
        }

        tombol.setBackground(dasar);
        tombol.setForeground(PUTIH);
        tombol.setFocusPainted(false);
        tombol.setBorder(BorderFactory.createEmptyBorder(8, 18, 8, 18));
        tombol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tombol.setOpaque(true);
        pasangHover(tombol, dasar, tekan);
    }

    public static void pasangHover(JButton tombol, Color dasar,
            Color tekan) {
        for (var pendengar : tombol.getMouseListeners()) {
            if (pendengar instanceof PendengarHover) {
                return; // sudah dipasang
            }
        }
        tombol.addMouseListener(new PendengarHover(tombol, dasar, tekan));
    }

    public static void gayaInput(JComponent input) {
        input.setBackground(PUTIH);
        input.setForeground(TEBAS);
        input.setFont(FONT_NORMAL);
        input.setBorder(new LineBorder(GARIS, 1, true));
        if (input instanceof JTextField
                || input instanceof JPasswordField) {
            input.setPreferredSize(null);
        }
        input.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                input.setBorder(new LineBorder(ORANYE, 2, true));
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                input.setBorder(new LineBorder(GARIS, 1, true));
            }
        });
    }

    public static void gayaCombo(JComboBox<?> combo) {
        combo.setBackground(PUTIH);
        combo.setForeground(TEBAS);
        combo.setFont(FONT_NORMAL);
        combo.setBorder(new LineBorder(GARIS, 1, true));
        combo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void gayaSpinner(JComponent spinner) {
        spinner.setBackground(PUTIH);
        spinner.setFont(FONT_NORMAL);
    }

    public static void gayaTabel(JTable tabel) {
        JTableHeader header = tabel.getTableHeader();
        header.setBackground(BIRU);
        header.setForeground(PUTIH);
        header.setFont(FONT_TEbal);
        header.setPreferredSize(new java.awt.Dimension(0, 34));
        header.setReorderingAllowed(false);

        tabel.setFont(FONT_NORMAL);
        tabel.setRowHeight(26);
        tabel.setShowGrid(true);
        tabel.setGridColor(new Color(228, 232, 238));
        tabel.setSelectionBackground(new Color(255, 224, 204));
        tabel.setSelectionForeground(TEBAS);
        tabel.setDefaultRenderer(Object.class, rendererZebra());
    }

    /** Label teks biasa diberi warna teks yang konsisten. */
    public static void gayaLabel(JLabel label) {
        if (label.getForeground().equals(javax.swing.UIManager
                .getDefaults().getColor("Label.foreground"))) {
            label.setForeground(TEBAS);
        }
    }

    private static DefaultTableCellRenderer rendererZebra() {
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable tabel, Object nilai, boolean terpilih,
                    boolean fokus, int baris, int kolom) {
                Component c = super.getTableCellRendererComponent(
                        tabel, nilai, terpilih, fokus, baris, kolom);
                if (!terpilih) {
                    c.setBackground(baris % 2 == 0 ? PUTIH
                            : LATAR_SEKUNDER);
                }
                if (c instanceof JLabel label) {
                    label.setHorizontalAlignment(SwingConstants.LEFT);
                    label.setBorder(BorderFactory.createEmptyBorder(
                            0, 8, 0, 8));
                }
                return c;
            }
        };
        return renderer;
    }

    private static class PendengarHover extends MouseAdapter {
        private final JButton tombol;
        private final Color dasar;
        private final Color tekan;

        PendengarHover(JButton tombol, Color dasar, Color tekan) {
            this.tombol = tombol;
            this.dasar = dasar;
            this.tekan = tekan;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            tombol.setBackground(tekan);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            tombol.setBackground(dasar);
        }
    }
}
