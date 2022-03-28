public class ToBegin implements FootballState {

    FootballGame footballGame;

    public ToBegin(FootballGame newFootballGame){
        this.footballGame = newFootballGame;
    }

    @Override
    public void startGame() {
        footballGame.setFootballState(footballGame.getStartedState());
        System.out.println("O jogo começou!");
    }

    @Override
    public void endGame() {
        System.out.println("O jogo não pode acabar antes de começar!");
    }

    @Override
    public void visitedGoal() {
        System.out.println("As equipas não podem marcar antes do jogo começar!");
    }

    @Override
    public void visitorGoal() {
        System.out.println("As equipas não podem marcar antes do jogo começar!");
    }

    @Override
    public void currentScore() {
        System.out.println("O jogo ainda não começou!");
    }
}
