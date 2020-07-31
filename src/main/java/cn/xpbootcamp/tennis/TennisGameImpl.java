package cn.xpbootcamp.tennis;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGameImpl implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (DeuceCondition()) return "Deuce";

        if (AllCondition()) return GetScoreName(P1point, score) + "-All";

        score = GetScoreName(P1point, score) + "-" + GetScoreName(P2point, score);

        score = AdvantageCondition(score);

        score = WinCondition(score);
        return score;
    }

    private boolean AllCondition() {
        if (P1point == P2point && P1point < 4) {
            return true;
        }
        return false;
    }

    private boolean DeuceCondition() {
        if (P1point == P2point && P1point >= 3)
            return true;
        return false;
    }

    private String GetScoreName(int points, String score) {
        if (points == 0)
            score = "Love";
        if (points == 1)
            score = "Fifteen";
        if (points == 2)
            score = "Thirty";
        if (points == 3) {
            score = "Forty";
        }
        return score;
    }

    private String AdvantageCondition(String score) {
        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }
        return score;
    }

    private String WinCondition(String score) {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}