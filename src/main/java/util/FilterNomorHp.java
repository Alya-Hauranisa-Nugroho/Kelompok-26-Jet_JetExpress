package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FilterNomorHp extends DocumentFilter {

    public static final int PANJANG_MAKSIMAL = 13;

    public static final int PANJANG_AWALAN = 2;

    private boolean modeProgram = false;

    void setModeProgram(boolean aktif) {
        this.modeProgram = aktif;
    }

    private String hanyaAngka(String teks) {
        if (teks == null) {
            return "";
        }
        return teks.replaceAll("[^0-9]", "");
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fb,
            int offset, String teks, AttributeSet attr)
            throws BadLocationException {
        if (modeProgram) {
            fb.insertString(offset, teks, attr);
            return;
        }

        String angka = hanyaAngka(teks);

        if (angka.isEmpty()) {
            return;
        }

        if (offset < PANJANG_AWALAN) {
            return;
        }

        int panjangBaru = fb.getDocument().getLength()
                + angka.length();
        if (panjangBaru > PANJANG_MAKSIMAL) {
            return;
        }

        fb.insertString(offset, angka, attr);
    }

    @Override
    public void remove(DocumentFilter.FilterBypass fb,
            int offset, int length)
            throws BadLocationException {
        if (modeProgram) {
            fb.remove(offset, length);
            return;
        }

        if (offset < PANJANG_AWALAN) {
            return;
        }

        fb.remove(offset, length);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb,
            int offset, int length, String teks, AttributeSet attr)
            throws BadLocationException {
        if (modeProgram) {
            fb.replace(offset, length, teks, attr);
            return;
        }

        if (offset < PANJANG_AWALAN) {
            return;
        }

        String angka = hanyaAngka(teks);

        if (angka.isEmpty()) {
            return;
        }

        int panjangBaru = fb.getDocument().getLength()
                - length + angka.length();
        if (panjangBaru > PANJANG_MAKSIMAL) {
            return;
        }

        fb.replace(offset, length, angka, attr);
    }
}
