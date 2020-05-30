package life;

public class State {
    char[][] current;
    char[][] next;
    int[][] neighbour;
    int size;

    State(char[][] cur) {
        this.current = cur;
        this.size = cur.length;
        this.findNeighbour();
        this.next = new char[cur.length][cur.length];
    }

    public void findNeighbour() {
        int s = current.length;
        char[][] period = new char[s + 2][s + 2];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                period[i + 1][j + 1] = current[i][j];
            }
            period[0][i + 1] = current[s - 1][i];
            period[s + 1][i + 1] = current[0][i];
            period[i + 1][0] = current[i][s - 1];
            period[i + 1][s + 1] = current[i][0];
        }
        period[0][0] = current[s - 1][s - 1];
        period[s + 1][s + 1] = current[0][0];
        period[s + 1][0] = current[0][s - 1];
        period[0][s + 1] = current[s - 1][0];

        neighbour = new int[s][s];
        for (int k = 1; k <= s; k++) {
            for (int l = 1; l <= s; l++) {
                int c = 0;
                if (period[k][l + 1] == 'O')
                    c++;
                if (period[k - 1][l + 1] == 'O')
                    c++;
                if (period[k - 1][l] == 'O')
                    c++;
                if (period[k - 1][l - 1] == 'O')
                    c++;
                if (period[k][l - 1] == 'O')
                    c++;
                if (period[k + 1][l - 1] == 'O')
                    c++;
                if (period[k + 1][l] == 'O')
                    c++;
                if (period[k + 1][l + 1] == 'O')
                    c++;
                neighbour[k - 1][l - 1] = c;
            }
        }
    }
}
