public class Started implements FootballState{

    FootballGame footballGame;

    public Started(FootballGame newFootballGame){
        this.footballGame = newFootballGame;
    }


    @Override
    public void startGame() {
        System.out.println("O jogo já começou!");
    }

    @Override
    public void endGame() {
        footballGame.setFootballState(footballGame.getEndedState());
        System.out.println("Termina assim o jogo!");
    }

    @Override
    public void visitedGoal() {
        footballGame.scoreGoalsVisited();
        System.out.println("Golo da equipa visitada!");
    }

    @Override
    public void visitorGoal() {
        footballGame.scoreGoalsVisitor();
        System.out.println("Golo da equipa visitante!");
    }

    @Override
    public void currentScore() {
        System.out.println("O jogo encontra-se: " +footballGame.getGoalsVisited() +
                           " para a equipa visitada e " + footballGame.getGoalsVisitor() + " para a equipa visitante!");
    }
}
