package life;

public class Life {
    public static int nextGeneration(State state) {
        int alive = 0;
        for (int i = 0; i < state.size; i++) {
            for (int j = 0; j < state.size; j++) {
                if (state.neighbour[i][j] < 2 && state.current[i][j] == 'O') {
                    state.next[i][j] = ' ';
                } else if (state.neighbour[i][j] > 3 && state.current[i][j] == 'O') {
                    state.next[i][j] = ' ';
                } else if (state.neighbour[i][j] == 3 && state.current[i][j] == ' ') {
                    state.next[i][j] = 'O';
                } else {
                    state.next[i][j] = state.current[i][j];
                }

            }
        }
        for (int i = 0; i < state.size; i++) {
            for (int j = 0; j < state.size; j++) {
                state.current[i][j] = state.next[i][j];
                if (state.current[i][j] == 'O') {
                    alive++;
                }
            }
        }
        state.findNeighbour();
        return alive;
    }
}
