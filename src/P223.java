/**
 * Created by jun on 1/16/16.
 * 223. Rectangle Area
 */
public class P223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A>=G || B>=H || E>=C || F>=D)
            return (C-A) * (D-B) + (G-E) *(H-F);

        int a = Math.max(A, E);
        int b = Math.max(B, F);
        int c = Math.min(C, G);
        int d = Math.min(D, H);

        return (C-A) * (D-B) + (G-E) *(H-F) - (c-a) * (d-b);

    }
}
