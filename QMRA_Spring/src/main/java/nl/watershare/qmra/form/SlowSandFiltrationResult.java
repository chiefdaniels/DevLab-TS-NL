package nl.watershare.qmra.form;

import nl.watershare.qmra.service.SlowSandFiltrationModel;
import nl.watershare.qmra.service.SelectionCriteria;

public class SlowSandFiltrationResult {
	
	private SelectionCriteria selectionCriteria;
	private SlowSandFiltrationModel ssfModel;
		
	public SlowSandFiltrationResult(
			SelectionCriteria selectionCriteria,
			SlowSandFiltrationModel ssfModel) {
		
		super();
		this.selectionCriteria = selectionCriteria;
		this.ssfModel = ssfModel;
	}
	
	public SelectionCriteria getSelectionCriteria() {
		return selectionCriteria;
	}
	public SlowSandFiltrationModel getSlowSandFiltrationModel() {
		return ssfModel;
	}
	
}
