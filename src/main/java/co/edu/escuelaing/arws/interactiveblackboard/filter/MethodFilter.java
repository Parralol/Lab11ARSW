package co.edu.escuelaing.arws.interactiveblackboard.filter;

import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.StubMethod;
import net.bytebuddy.matcher.ElementMatchers;
import co.edu.escuelaing.arws.interactiveblackboard.annotations.GeneratedExcludeFromCodeCoverage;
import co.edu.escuelaing.arws.interactiveblackboard.controllers.EjemploController;

@GeneratedExcludeFromCodeCoverage
public class MethodFilter {

    public static void main(String[] args) {
        // Install the Byte Buddy agent
        ByteBuddyAgent.install();

        // Redefine the EjemploController class
        new ByteBuddy()
            .redefine(EjemploController.class)
            .method(ElementMatchers.isAnnotatedWith(GeneratedExcludeFromCodeCoverage.class))
            .intercept(StubMethod.INSTANCE)  // No-op: the method does nothing
            .make()
            .load(EjemploController.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
    }
}