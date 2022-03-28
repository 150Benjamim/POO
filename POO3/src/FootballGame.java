public class FootballGame {

    private FootballState toBegin;
    private FootballState started;
    private FootballState ended;

    private FootballState footballState;

    private int goalsVisited = 0, goalsVisitor = 0;

    public FootballGame(){
        toBegin = new ToBegin(this);
        started = new Started(this);
        ended = new Ended(this);

        footballState = toBegin;
    }

    public void setFootballState(FootballState newFootballState){
        this.footballState = newFootballState;
    }

    public void startGame(){
        this.footballState.startGame();
    }

    public void endGame(){
        this.footballState.endGame();
    }

    public void visitedGoal(){
        this.footballState.visitedGoal();
    }

    public void visitorGoal(){
        this.footballState.visitorGoal();
    }

    public FootballState getToBeginState(){
        return this.toBegin;
    }

    public FootballState getStartedState(){
        return this.started;
    }

    public FootballState getEndedState(){
        return this.ended;
    }


    public int getGoalsVisited() {
        return this.goalsVisited;
    }
    public int getGoalsVisitor(){
        return this.goalsVisitor;
    }

    public void scoreGoalsVisited(){
        this.goalsVisited += 1;
    }
    public void scoreGoalsVisitor(){
        this.goalsVisitor += 1;
    }





}