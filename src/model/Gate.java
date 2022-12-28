package model;

import model.states.StateContext;

public class Gate {

    private String name;
    private final StateContext context;

    public Gate(String name) {
        this.name = name;
        this.context = new StateContext();
    }


    public String getName() {
        return this.name;
    }

    public StateContext getContext() {
        return this.context;
    }

    public void scan() {
        context.getState().scan(context);
    }

    public void walkThroughGate() {
        context.getState().walkThroughGate(context);
    }

    public void activate() {
        context.getState().activate(context);
    }


    public void deactivate() {
        context.getState().deactivate(context);
    }

    public void createAlert() {
        context.getState().createAlert(context);
    }

    public void createWarning() {
        context.getState().createWarning(context);
    }

    public void setClosed() {
        context.getState().setClosed(context);
    }


}
