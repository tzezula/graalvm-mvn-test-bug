package org.example.graalvm.mvn.test.bug.components;

import org.graalvm.polyglot.Context;
import org.springframework.stereotype.Component;

@Component
public class MavenTestBug {
    public void run() {
        Context context = Context.create();
        context.eval("js", "print('\\n\\n\\n\\nHELLO WORLD!\\n\\n\\n\\n');");
    }
}
