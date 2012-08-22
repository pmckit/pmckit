package org.pmckit.helpers.annotations.processors;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

import org.pmckit.helpers.annotations.BeCareful;

@SupportedAnnotationTypes("org.pmckit.helpers.annotations.BeCareful")
public class Processor extends AbstractProcessor {

    private ProcessingEnvironment env;

    @Override
    public synchronized void init(ProcessingEnvironment pe) {
        this.env = pe;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (TypeElement te : annotations) {
           
            	BeCareful annotation = (BeCareful) te.getAnnotation(BeCareful.class);
                final Set< ? extends Element> elts = roundEnv.getElementsAnnotatedWith(te);
                for (Element elt : elts) {
                	
                    env.getMessager().printMessage(Kind.WARNING,
                            String.format("%s : %s => %s", roundEnv.getRootElements(), elt,te.getEnclosedElements().get(0)),
                            elt);
                }
            }
        }
        return true;
    }

}