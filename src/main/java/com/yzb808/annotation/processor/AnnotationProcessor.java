package com.yzb808.annotation.processor;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;

import com.google.auto.service.AutoService;

/*
 * @AutoService是google触屏的自动创建Spi目录的工具，实现也基于插入式注解。
 */
@AutoService(Processor.class)
public class AnnotationProcessor extends AbstractProcessor {
	
	/*
	 * 使用mvn编译时，默认只输出error级别的信息，同时中断编译过程
	 */
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		processingEnv.getMessager().printMessage(Kind.NOTE, "AnnotationProcessor init note");
		processingEnv.getMessager().printMessage(Kind.WARNING, "AnnotationProcessor init warning");
	}
	
	/*
	 * 可以用@SupportedSourceVersion注解代替，但必须要指定常量。
	 * 处于兼容性考虑，用方法比用注解好(例如android)。
	 */
	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}
	
	/*
	 * 可以用@SupportedAnnotationTypes注解代替getSupportedAnnotationTypes方法。
	 * 出于兼容性考虑，用方法比用注解好(例如android)。
	 */
	private static Set<String> annotations = new HashSet<>();
	static {
		annotations.add("com.yzb808.annotation.processor.HelloWorld");
	}
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return annotations;
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		if (!roundEnv.processingOver()) {
			processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Hello Worlds! note");
			processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "Hello Worlds! warning");
		}
		try {
			File file = new File("E:/annotationProcess");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			processingEnv.getMessager().printMessage(Kind.ERROR, e.getMessage());
		}
		return true;
	}

}
