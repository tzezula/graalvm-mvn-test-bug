package org.example.graalvm.mvn.test.bug.components;

import org.graalvm.polyglot.Context;
import org.springframework.stereotype.Component;

@Component
public class MavenTestBug {
    public void run() {
        ClassLoader orig = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(ClassLoader.getSystemClassLoader());
            Context context = Context.create();
            context.eval("js", "print('\\n\\n\\n\\nHELLO WORLD!\\n\\n\\n\\n');");
        } finally {
            Thread.currentThread().setContextClassLoader(orig);
        }
    }
}
