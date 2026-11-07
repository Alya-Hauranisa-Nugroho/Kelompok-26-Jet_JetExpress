package util;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.text.JTextComponent;

public final class TeksPetunjuk {

    private TeksPetunjuk() {
    }

    public static void pasang(JTextComponent field, String petunjuk) {
        Color warnaAsli = field.getForeground();

        Runnable terapkan = () -> {
            boolean kosong = field.getText() == null
                    || field.getText().isEmpty();
            if (kosong) {
                field.setText(petunjuk);
                field.setForeground(Color.GRAY);
            }
        };

        field.putClientProperty("petunjuk", petunjuk);
        field.putClientProperty("warnaAsli", warnaAsli);

        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isPetunjukTampil(field)) {
                    field.setText("");
                    field.setForeground(warnaAsli);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                terapkan.run();
            }
        });

        terapkan.run();
    }

    public static boolean isPetunjukTampil(JTextComponent field) {
        String petunjuk = (String) field.getClientProperty("petunjuk");
        return petunjuk != null
                && petunjuk.equals(field.getText())
                && Color.GRAY.equals(field.getForeground());
    }

    public static String ambilNilai(JTextComponent field) {
        if (isPetunjukTampil(field)) {
            return "";
        }
        return field.getText() == null ? "" : field.getText().trim();
    }

    public static void reset(JTextComponent field) {
        field.setText("");
        field.setForeground((Color) field
                .getClientProperty("warnaAsli"));
        String petunjuk = (String) field.getClientProperty("petunjuk");
        if (petunjuk != null) {
            field.setText(petunjuk);
            field.setForeground(Color.GRAY);
        }
    }
}
