/*******************************************************************************
 * Copyright (C) 2010 - 2016. TIBCO Software Inc. 
 * All Rights Reserved. Confidential & Proprietary.
 ******************************************************************************/
package net.sf.jasperreports.eclipse.classpath.container;

import java.util.ArrayList;

import net.sf.jasperreports.eclipse.messages.Messages;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPageExtension;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class JRClasspathContainerPage extends WizardPage
		implements IClasspathContainerPage, IClasspathContainerPageExtension {
	private ArrayList<IPath> fUsedPaths;

	public JRClasspathContainerPage() {
		super("JR Library"); //$NON-NLS-1$
		setTitle(Messages.JRClasspathContainerPage_Title);
		setDescription(Messages.JRClasspathContainerPage_Description);
		setPageComplete(true);
		fUsedPaths = new ArrayList<>();
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());

		Label lbl = new Label(composite, SWT.NONE);
		lbl.setText(Messages.JRClasspathContainerPage_InfoText);
		lbl.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_CENTER));

		setControl(composite);
	}

	@Override
	public void initialize(IJavaProject project, IClasspathEntry[] currentEntries) {
		jrcc = new JRClasspathContainer(null, project);
		for (int i = 0; i < currentEntries.length; i++) {
			IClasspathEntry curr = currentEntries[i];
			if (curr.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
				fUsedPaths.add(curr.getPath());
			}
		}
	}

	@Override
	public boolean finish() {
		return true;
	}

	private JRClasspathContainer jrcc;

	@Override
	public void setSelection(IClasspathEntry containerEntry) {
	}

	@Override
	public IClasspathEntry getSelection() {
		return JavaCore.newContainerEntry(JRClasspathContainer.ID);
	}

}
