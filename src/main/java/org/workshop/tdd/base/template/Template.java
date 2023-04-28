package org.workshop.tdd.base.template;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Template {

  private Map<String, String> variables;
  private String templateText;

  public Template(String templateText) {
    this.variables = new HashMap<>();
    this.templateText = templateText;
  }

  public void setVariable(String variableName, String value) {
    this.variables.put(variableName, value);
  }

  public String evaluate() {
      // Design still not clear what to abstract ? Apply Triangulation
      // Remember to take tiny steps. Keep faking until design is clear, beware this may create infinite loop in going back to RED - GREEN - RED cycle
      // Hard code some more to defer the implementation of real behaviour for now
      // Triangulate reach the point Fake Hello, sees failing with new value. So now we need to fix it by adding Obvious Implementation
      // But at this point abstraction is little obvious. This method is doing some kind of template parsing
      // But before we straight go into Obvious implementation, lets make this test pass
      // We need go back to school and write failing test to reveal the Obvious implementation
      // ----
      // As we know obvious implementation. new test failing due to hard coded matching.
      // Goal here to tiny step again, Focus to make is go GREEN again quickly as possible
      // But here traignulate reach the tipping piont, We cannot make it green by Faking it. We already generalised the abstraction here.
      // What's next ?
      // Add Obvious implementation now.
      String result = templateText;
      for (Entry<String, String> entry : variables.entrySet()) {
        result = result.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue());
      }
      return result;
  }
}
