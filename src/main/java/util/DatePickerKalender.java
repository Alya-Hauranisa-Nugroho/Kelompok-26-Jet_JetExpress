package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;


public final class DatePickerKalender {

    private static final DateTimeFormatter FORMAT_TANGGAL =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter FORMAT_WAKTU =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String[] NAMA_HARI =
            {"Sen", "Sel", "Rab", "Kam", "Jum", "Sab", "Min"};

    private static final String[] NAMA_BULAN = {
        "Januari", "Februari", "Maret", "April", "Mei", "Juni",
        "Juli", "Agustus", "September", "Oktober", "November",
        "Desember"
    };

    private DatePickerKalender() {
    }

    public static void pasang(JTextField field) {
        pasang(field, false);
    }

    public static void pasangWaktu(JTextField field) {
        pasang(field, true);
    }

    private static void pasang(JTextField field, boolean denganWaktu) {
        field.setEditable(false);
        field.setFocusable(false);
        field.setToolTipText("Klik untuk memilih tanggal lewat kalender");
        field.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String hasil = bukaDialog(field, denganWaktu);
                if (hasil != null) {
                    field.setText(hasil);
                }
            }
        });
    }

    public static String bukaDialog(java.awt.Component induk,
            boolean denganWaktu) {
        Window pemilik = javax.swing.SwingUtilities
                .getWindowAncestor(induk);
        JDialog dialog = new JDialog(pemilik,
                "Pilih Tanggal", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(new BorderLayout());

        LocalDate hariIni = LocalDate.now();
        LocalDate[] kursor = {LocalDate.of(
                hariIni.getYear(), hariIni.getMonth(), 1)};

        JLabel labelBulan = new JLabel("", SwingConstants.CENTER);
        labelBulan.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelBulan.setForeground(new Color(0x00, 0x33, 0x99));

        JPanel panelAtas = new JPanel(new BorderLayout());
        JButton tombolSebelum = new JButton("<");
        JButton tombolSesudah = new JButton(">");
        panelAtas.add(tombolSebelum, BorderLayout.WEST);
        panelAtas.add(labelBulan, BorderLayout.CENTER);
        panelAtas.add(tombolSesudah, BorderLayout.EAST);

        JPanel panelGrid = new JPanel(new GridLayout(0, 7, 2, 2));
        panelGrid.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel panelBawah = new JPanel(new BorderLayout());

        final JSpinner[] pemilihWaktu = new JSpinner[3];
        if (denganWaktu) {
            LocalTime waktuKini = LocalTime.now();
            pemilihWaktu[0] = new JSpinner(new SpinnerNumberModel(
                    waktuKini.getHour(), 0, 23, 1));
            pemilihWaktu[1] = new JSpinner(new SpinnerNumberModel(
                    waktuKini.getMinute(), 0, 59, 1));
            pemilihWaktu[2] = new JSpinner(new SpinnerNumberModel(
                    waktuKini.getSecond(), 0, 59, 1));
            JPanel panelWaktu = new JPanel();
            panelWaktu.add(new JLabel("Jam"));
            panelWaktu.add(pemilihWaktu[0]);
            panelWaktu.add(new JLabel("Menit"));
            panelWaktu.add(pemilihWaktu[1]);
            panelWaktu.add(new JLabel("Detik"));
            panelWaktu.add(pemilihWaktu[2]);
            panelBawah.add(panelWaktu, BorderLayout.CENTER);
        }

        JButton tombolHariIni = new JButton("Hari Ini");
        JButton tombolBatal = new JButton("Batal");
        JPanel panelTombol = new JPanel();
        panelTombol.add(tombolHariIni);
        panelTombol.add(tombolBatal);
        panelBawah.add(panelTombol, BorderLayout.SOUTH);

        final String[] hasil = {null};

        Runnable gambarUlang = () -> {
            LocalDate awalBulan = kursor[0];
            labelBulan.setText(NAMA_BULAN[awalBulan.getMonthValue() - 1]
                    + " " + awalBulan.getYear());

            panelGrid.removeAll();
            for (String namaHari : NAMA_HARI) {
                JLabel label = new JLabel(namaHari, SwingConstants.CENTER);
                label.setFont(new Font("Segoe UI", Font.BOLD, 11));
                panelGrid.add(label);
            }

            int geser = awalBulan.getDayOfWeek().getValue() - 1;
            for (int i = 0; i < geser; i++) {
                panelGrid.add(new JLabel(""));
            }

            LocalDate akhirBulan = awalBulan.withDayOfMonth(
                    awalBulan.lengthOfMonth());
            for (LocalDate tanggal = awalBulan;
                    !tanggal.isAfter(akhirBulan);
                    tanggal = tanggal.plusDays(1)) {
                final LocalDate tanggalTerpilih = tanggal;
                JButton tombolTanggal = new JButton(
                        String.valueOf(tanggal.getDayOfMonth()));
                tombolTanggal.setMargin(new java.awt.Insets(1, 1, 1, 1));
                tombolTanggal.setFocusPainted(false);
                if (tanggal.equals(hariIni)) {
                    tombolTanggal.setForeground(new Color(
                            0xFF, 0x66, 0x00));
                }
                tombolTanggal.addActionListener(aksi -> {
                    if (denganWaktu) {
                        hasil[0] = tanggalTerpilih.format(FORMAT_TANGGAL)
                                + " "
                                + String.format("%02d:%02d:%02d",
                                        (int) pemilihWaktu[0].getValue(),
                                        (int) pemilihWaktu[1].getValue(),
                                        (int) pemilihWaktu[2].getValue());
                    } else {
                        hasil[0] = tanggalTerpilih.format(FORMAT_TANGGAL);
                    }
                    dialog.dispose();
                });
                panelGrid.add(tombolTanggal);
            }

            panelGrid.revalidate();
            panelGrid.repaint();
        };

        tombolSebelum.addActionListener(aksi -> {
            kursor[0] = kursor[0].minusMonths(1);
            gambarUlang.run();
        });
        tombolSesudah.addActionListener(aksi -> {
            kursor[0] = kursor[0].plusMonths(1);
            gambarUlang.run();
        });
        tombolHariIni.addActionListener(aksi -> {
            if (denganWaktu) {
                hasil[0] = LocalDateTime.now().format(FORMAT_WAKTU);
            } else {
                hasil[0] = hariIni.format(FORMAT_TANGGAL);
            }
            dialog.dispose();
        });
        tombolBatal.addActionListener(aksi -> dialog.dispose());

        gambarUlang.run();

        dialog.add(panelAtas, BorderLayout.NORTH);
        dialog.add(panelGrid, BorderLayout.CENTER);
        dialog.add(panelBawah, BorderLayout.SOUTH);
        dialog.getRootPane().setDefaultButton(tombolHariIni);
        dialog.setSize(denganWaktu ? 420 : 320, denganWaktu ? 420 : 340);
        dialog.setLocationRelativeTo(induk);
        dialog.setVisible(true);

        return hasil[0];
    }
}
