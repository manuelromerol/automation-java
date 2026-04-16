package org.sample.steps;

public class StepManager {
    private static final ThreadLocal<StepObjectsCentral> manager = new ThreadLocal<>();

    public static StepObjectsCentral getSteps() {
        return manager.get();
    }

    public static void setSteps(StepObjectsCentral stepsInstance) {
        manager.set(stepsInstance);
    }

    public static void clean() {
        manager.remove();
    }
}