package nl.watershare.qmra.form;

import nl.watershare.qmra.service.ChlorineDisinfectionModel;
import nl.watershare.qmra.service.SelectionCriteria;

public class ChlorineDisinfectionResult {
	
	private SelectionCriteria selectionCriteria;
	private ChlorineDisinfectionModel cdModel;
	private boolean showInactivation;
	private boolean showCTRequirements;
		
	public ChlorineDisinfectionResult(
			SelectionCriteria selectionCriteria,
			ChlorineDisinfectionModel cdModel,
			boolean showInactivation,
			boolean showCTRequirements) {
		
		super();
		this.selectionCriteria = selectionCriteria;
		this.cdModel = cdModel;
		this.showInactivation = showInactivation;
		this.showCTRequirements = showCTRequirements;
	}
	
	public SelectionCriteria getSelectionCriteria() {
		return selectionCriteria;
	}
	public ChlorineDisinfectionModel getChlorineDisinfectionModel() {
		return cdModel;
	}
	public boolean isShowInactivation() {
		return showInactivation;
	}
	public boolean isShowCTRequirements() {
		return showCTRequirements;
	}
	
}
