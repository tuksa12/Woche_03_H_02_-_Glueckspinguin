package pgdp.luckypenguin;

import static pgdp.MiniJava.*; //Diesen Import nicht löschen! Do not delete this import!

public class LuckyPenguin {
    public static void main(String[] args) {

        //Input from the user and error message.
        int n = readInt("Anzahl Pinguine:");
        while (n <= 1) {
            n = readInt("Anzahl Pinguine soll >1 sein:");
        }

        int m = readInt("Anfangsfische pro Pinguin:");
        while (m <= 0) {
            m = readInt("Anfangsfische soll >0 sein:");
        }

        int[] f_player = new int[n]; //Number of fish for each penguin.
        int[] player_response = new int[n]; //Response from the user, if he wants to continue or not.
        int x = 0;
        int d = n; //d is the number of players still in game.
        int round1 = 0;

        //Number of fish in each field.
        int f3 = 0;
        int f4 = 0;
        int f5 = 0;
        int f6 = 0;
        int f7 = 0;
        int f8 = 0;
        int f9 = 0;
        int f10 = 0;
        int f11 = 0;

        //Game.
        A:while (d != 0) {
            while (player_response[x] != 1) {
                if (round1 < n) {//Comparison to see if it is the first round of the game.
                    f_player[x] = m;
                }

                writeBoard(f3, f4, f5, f6, f7, f8, f9, f10, f11);
                write("Pinguin " + x + " ist dran:");

                if (d == 1) {//Comparison to see if the player is the last penguin standing in the game.
                    f_player[x] += +f3 + f4 + f5 + f6 + f7 + f8 + f9 + f10 + f11;
                    write("Sie sind der letzte mitspielende Pinguin! Sie gewinnen alle Fische auf dem Brett!");
                    break A;
                } else {
                    int w1 = dice();
                    int w2 = dice();
                    int sum = w1 + w2;
                    write(w1 + " + " + w2 + " = " + sum + " wurde gewürfelt.");

                    //Condition for F7.
                    if (sum == 7) {
                        f_player[x]--;
                        f7++;
                        write("Hochzeit! Sie schenken einen Fisch und legen ihn auf F7.");

                    //Condition for F2.
                    } else if (sum == 2) {
                        f_player[x] += f3 + f4 + f5 + f6 + f8 + f9 + f10 + f11;
                        f3 = 0;
                        f4 = 0;
                        f5 = 0;
                        f6 = 0;
                        f8 = 0;
                        f9 = 0;
                        f10 = 0;
                        f11 = 0;
                        write("Glückspinguin! Sie gewinnen alle Fische auf dem Brett außer von F7!");

                    //Condition for F12.
                    } else if (sum == 12) {
                        f_player[x] += +f3 + f4 + f5 + f6 + f7 + f8 + f9 + f10 + f11;
                        f3 = 0;
                        f4 = 0;
                        f5 = 0;
                        f6 = 0;
                        f7 = 0;
                        f8 = 0;
                        f9 = 0;
                        f10 = 0;
                        f11 = 0;
                        write("Königspinguin! Sie gewinnen alle Fische auf dem Brett!");

                    //Conditions for the other fields.
                    } else {
                        if (sum == 3 && f3 == 0) {
                            f_player[x]--;
                            f3++;
                            write("Sie legen einen Fisch auf F" + sum + ".");
                        } else if (sum == 3 && f3 == 1) {
                            f_player[x]++;
                            f3--;
                            write("Sie nehmen den Fisch von F" + sum + ".");
                        }

                        if (sum == 4 && f4 == 0) {
                            f_player[x]--;
                            f4++;
                            write("Sie legen einen Fisch auf F" + sum + ".");
                        } else if (sum == 4 && f4 == 1) {
                            f_player[x]++;
                            f4--;
                            write("Sie nehmen den Fisch von F" + sum + ".");
                        }

                        if (sum == 5 && f5 == 0) {
                            f_player[x]--;
                            f5++;
                            write("Sie legen einen Fisch auf F" + sum + ".");
                        } else if (sum == 5 && f5 == 1) {
                            f_player[x]++;
                            f5--;
                            write("Sie nehmen den Fisch von F" + sum + ".");
                        }

                        if (sum == 6 && f6 == 0) {
                            f_player[x]--;
                            f6++;
                            write("Sie legen einen Fisch auf F" + sum + ".");
                        } else if (sum == 6 && f6 == 1) {
                            f_player[x]++;
                            f6--;
                            write("Sie nehmen den Fisch von F" + sum + ".");
                        }

                        if (sum == 8 && f8 == 0) {
                            f_player[x]--;
                            f8++;
                            write("Sie legen einen Fisch auf F" + sum + ".");
                        } else if (sum == 8 && f8 == 1) {
                            f_player[x]++;
                            f8--;
                            write("Sie nehmen den Fisch von F" + sum + ".");
                        }

                        if (sum == 9 && f9 == 0) {
                            f_player[x]--;
                            f9++;
                            write("Sie legen einen Fisch auf F" + sum + ".");
                        } else if (sum == 9 && f9 == 1) {
                            f_player[x]++;
                            f9--;
                            write("Sie nehmen den Fisch von F" + sum + ".");
                        }

                        if (sum == 10 && f10 == 0) {
                            f_player[x]--;
                            f10++;
                            write("Sie legen einen Fisch auf F" + sum + ".");
                        } else if (sum == 10 && f10 == 1) {
                            f_player[x]++;
                            f10--;
                            write("Sie nehmen den Fisch von F" + sum + ".");
                        }

                        if (sum == 11 && f11 == 0) {
                            f_player[x]--;
                            f11++;
                            write("Sie legen einen Fisch auf F" + sum + ".");
                        } else if (sum == 11 && f11 == 1) {
                            f_player[x]++;
                            f11--;
                            write("Sie nehmen den Fisch von F" + sum + ".");
                        }
                    }

                    //Console feedback for the number of fish / Player response to quit the game.
                    if (f_player[x] > 1) {
                        write("Sie haben jetzt " + f_player[x] + " Fische!");
                        player_response[x] = readInt("Geben Sie 1 ein, um jetzt das Spiel zu verlassen:");
                    } else if (f_player[x] == 1) {
                        write("Sie haben jetzt " + f_player[x] + " Fisch!");
                        player_response[x] = readInt("Geben Sie 1 ein, um jetzt das Spiel zu verlassen:");
                    } else {
                        write("Sie haben jetzt " + f_player[x] + " Fische!");
                        write("Sie haben alle Fische verloren, daher können Sie nicht mehr spielen!");
                        player_response[x] = 1;
                    }
                    //Condition to see if a player left the game.
                    if (player_response[x] == 1) {
                        d--;
                    }

                    //Condition to make the loop possible only for the right number of penguins.
                    if (x < (n - 1)) {
                        x++;
                    } else {
                        x = 0;
                    }
                    round1++;
                }
            }
            x++;
        }

        //Loop to find the biggest number of fish among the penguins
        int winner = 0;
        x= 0;
        while (x < n-1){
            if (f_player[x]>f_player[x+1]){
                if (winner<f_player[x]){
                    winner = f_player[x];}
            }
            else if (f_player[x]<f_player[x+1]){
                if (winner<f_player[x+1]){
                    winner = f_player[x+1];}}
            x++;
        }

        //Announcement of the winner/s of the game.
        x=0;
        write("Die Gewinnerpinguine mit "+winner+" Fischen:");
        while (x<n){
            if (f_player[x] == winner){
                write("Pinguin "+x);}
        x++;}
    }
}

