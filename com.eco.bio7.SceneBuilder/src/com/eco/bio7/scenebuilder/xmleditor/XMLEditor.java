package com.eco.bio7.scenebuilder.xmleditor;

import javafx.embed.swt.FXCanvas;

import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import com.eco.bio7.scenebuilder.xmleditor.ColorManager;
import com.eco.bio7.scenebuilder.xmleditor.XMLConfiguration;
import com.eco.bio7.scenebuilder.xmleditor.XMLDocumentProvider;
import com.oracle.javafx.scenebuilder.kit.editor.EditorController;

public class XMLEditor extends TextEditor {

	private ColorManager colorManager;
	private EditorController controller;
	private FXCanvas guiCanvas;
	protected IDocument doc;

	public XMLEditor(EditorController editorController, FXCanvas canvas) {
		super();
		this.controller = editorController;
		this.guiCanvas = canvas;
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager, this));
		setDocumentProvider(new XMLDocumentProvider());
	}

	public EditorController getController() {
		return controller;
	}

	public FXCanvas getGuiCanvas() {
		return guiCanvas;
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
