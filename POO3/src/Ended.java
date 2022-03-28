public class Ended implements FootballState{

    FootballGame footballGame;

    public Ended(FootballGame newFootballGame){
        this.footballGame = newFootballGame;
    }

    @Override
    public void startGame() {
        System.out.println("Jogo já acabou!");
    }

    @Override
    public void endGame() {
        System.out.println("Jogo já acabou!");
    }

    @Override
    public void visitedGoal() {
        System.out.println("O jogo já acabou!");
    }

    @Override
    public void visitorGoal() {
        System.out.println("O jogo já acabou!");
    }

    @Override
    public void currentScore() {
        System.out.println("O jogo encontra-se: " +footballGame.getGoalsVisited() +
                           " para a equipa visitada e " + footballGame.getGoalsVisitor() + " para a equipa visitante!");
    }

}
