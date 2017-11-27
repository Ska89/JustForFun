import java.util.Scanner;

/**
 * Created by @Serhii Sydorenko on 22.10.2017.
 *
 * This task is the reverse of Pitch and Notes (so perhaps you may want to read or solve it first) - suppose you are
 * building the electronic tuner for guitar, violin or piano - and you already connected microphone to microcontroller
 * and succeeded in registering the sound wave, smoothering it and measuring its frequency.

 Now the only thing remained is to write a part of program responsible for determining the note played by its frequency.
 I.e. if the device have detected sound of 440 Hz it should be able to tell that note A4 is played.

 Since in reality instruments could be slightly out of tune, you need not expect that pitch will be mathematically
 exact. Nevertheless you'll be able to determine the nearest note. I.e. frequencies of 433 Hz or 449 Hz should anyway
 be classified as A4.

 Input data contains number of notes to identify.
 The next line will provide the frequencies, separated by spaces.
 Answer should contain identified note names.

 Example:

 input data:
 16
 185.4 115.3 203.9 55.2 52.7 86.6 932.3 229.8 61.8 66.1 363.7 771.4 594.4 48.2 102.6 222.4

 answer:
 F#3 A#2 G#3 A1 G#1 F2 A#5 A#3 B1 C2 F#4 G5 D5 G1 G#2 A3

 */
public class InstrumentTuner {
    private static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    private static double[] FREQ_4_OCT;
    private static final double STEP = Math.pow(2, (double) 1 / 12);

    public static void main(String[] args) throws Exception {
        fillFrequencyArray();
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(findNote(Double.parseDouble(sc.next())));
            if (i < count - 1) sb.append(" ");
        }
        sc.close();
        printResult(sb);
    }

    private static void fillFrequencyArray() {
        FREQ_4_OCT = new double[12];
        FREQ_4_OCT[9] = 440;
        for (int i = 10; i < 12; i++)
            FREQ_4_OCT[i] = FREQ_4_OCT[i - 1] * STEP;
        for (int i = 8; i >= 0; i--)
            FREQ_4_OCT[i] = FREQ_4_OCT[i + 1] / STEP;
    }

    private static String findNote(double freq) {
        double ratio = 1;
        int oct = 4;
        if (freq > (FREQ_4_OCT[11] + (FREQ_4_OCT[11] * STEP - FREQ_4_OCT[11]) / 2)) {
            for (int i = 1; i < 5; i++) {
                int r = (int) Math.pow(2, Math.abs(i));
                if (freq <= (FREQ_4_OCT[11] * r
                        + (FREQ_4_OCT[11] * r * STEP
                        - FREQ_4_OCT[11] * r) / 2)
                        && freq >= (FREQ_4_OCT[0] * r
                        + (FREQ_4_OCT[0] * r
                        - FREQ_4_OCT[0] * r / STEP) / 2)) {
                    ratio = r;
                    oct += i;
                }
            }
        } else if (freq < (FREQ_4_OCT[0] + (FREQ_4_OCT[0] - FREQ_4_OCT[0] / STEP) / 2)) {
            for (int i = 1; i < 5; i++) {
                int r = (int) Math.pow(2, Math.abs(i));
                if (freq <= (FREQ_4_OCT[11] / r
                        + (FREQ_4_OCT[11] / r * STEP
                        - FREQ_4_OCT[11] / r) / 2)
                        && freq > (FREQ_4_OCT[11] / (2 * r)
                        + (FREQ_4_OCT[11] / (2 * r)
                        - FREQ_4_OCT[11] / (2 * r * STEP)) / 2)) {
                    ratio = (double) 1 / r;
                    oct -= i;
                }
            }
        }
        for (int i = 0; i < 12; i++) {
            double nFreq = FREQ_4_OCT[i] * ratio, down = (nFreq - nFreq / STEP) / 2;
            if (freq <= nFreq || i == 11) return NOTES[i] + oct;
            else if (freq > nFreq && freq <= FREQ_4_OCT[i + 1] * ratio) {
                if (freq - nFreq <= down) return NOTES[i] + oct;
                return NOTES[i + 1] + oct;
            }
        }
        return "";
    }

    private static void printResult(StringBuilder res) {
        System.out.println(res);
    }
}
