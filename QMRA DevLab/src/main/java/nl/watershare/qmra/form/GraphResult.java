package nl.watershare.qmra.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nl.watershare.qmra.entity.ResearchData;
import nl.watershare.qmra.service.SelectionCriteria;

public class GraphResult {

	private SelectionCriteria selectionCriteria = null;
	private List<ResearchData> researchDataList = null;
	
	Comparator<ResearchData> researchDataComparator_avg = new Comparator<ResearchData>() {
	    public int compare(ResearchData rd1, ResearchData rd2) {
	    	if (rd1.getAvg() < rd2.getAvg()) {
	    		return -1;
	    	} else if (rd1.getAvg() > rd2.getAvg()) {
	    		return 1;
	    	} else {
	    		return 0;
	    	}
	    }
	};

	Comparator<ResearchData> researchDataComparator_kValue = new Comparator<ResearchData>() {
	    public int compare(ResearchData rd1, ResearchData rd2) {
	    	if (rd1.getVirus_kValue() < rd2.getVirus_kValue()) {
	    		return -1;
	    	} else if (rd1.getVirus_kValue() > rd2.getVirus_kValue()) {
	    		return 1;
	    	} else {
	    		return 0;
	    	}
	    }
	};

	public GraphResult(SelectionCriteria selectionCriteria,
			List<ResearchData> researchDataList) {
		
		super();
		this.selectionCriteria = selectionCriteria;
		this.researchDataList = researchDataList;
	}

	public SelectionCriteria getSelectionCriteria() {
		return selectionCriteria;
	}
	public List<ResearchData> getResearchDataList() {
		return researchDataList;
	}

	public List<FlotGraph> getGraphList() {	
		List<FlotGraph> graphList = new ArrayList<FlotGraph>();
		
		List<FlotLabel> yaxisLabels = new ArrayList<FlotLabel>();
		
		if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) ||
			(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){
				
			Collections.sort(researchDataList, researchDataComparator_avg);
			
			int index = 1;
			double max = 0;
			List<Object> graphData = new ArrayList<Object>();
			for (ResearchData researchData: researchDataList) {
				List<Object> point = new ArrayList<Object>();
				point.add(((100.0 / researchDataList.size()) * index));
				point.add(researchData.getAvg());
				point.add(researchData.getAvg_stdDev());
				graphData.add(point);
				
				index++;
				if (researchData.getAvg() + researchData.getAvg_stdDev() > max) {
					max = researchData.getAvg() + researchData.getAvg_stdDev();
				}
			}
			
			FlotGraph graph = new FlotGraph();
			graph.setMaxValue(max * 1.1); // Add 10% to maximum size
			graph.setYaxisLabels(yaxisLabels);
			graph.setGraphData(graphData);
			graphList.add(graph);
				
		} else if ((selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getDisinfectionType() == DisinfectionType.UV)){
	
			Collections.sort(researchDataList, researchDataComparator_kValue);

			int index = 0;
			double max = 0;
			
			List<Object> targetLPGraphData = new ArrayList<Object>();
			List<Object> targetMPGraphData = new ArrayList<Object>();
			List<Object> targetLPErrorGraphData = new ArrayList<Object>();
			List<Object> targetMPErrorGraphData = new ArrayList<Object>();
			List<Object> surrogateLPGraphData = new ArrayList<Object>();
			List<Object> surrogateMPGraphData = new ArrayList<Object>();
			List<Object> surrogateLPErrorGraphData = new ArrayList<Object>();
			List<Object> surrogateMPErrorGraphData = new ArrayList<Object>();
			
			for (ResearchData researchData: researchDataList) {
				
				if (researchData.getOrganismTarget()) { // Add target point data to graph
					if (researchData.getVirus_uvType() == UvType.LP) { // Add lp point data to graph
						addPoint(targetLPGraphData, researchData.getVirus_kValue(), researchData.getOrganism());
						addPoint(targetMPGraphData, 0.0, researchData.getOrganism());
						addPoint(surrogateLPGraphData, 0.0, researchData.getOrganism());
						addPoint(surrogateMPGraphData, 0.0, researchData.getOrganism());
						addPoint(targetLPErrorGraphData, researchData.getVirus_kValue(), researchData.getOrganism(), researchData.getVirus_cl95());
					} else { // Add mp point data to graph
						addPoint(targetMPGraphData, researchData.getVirus_kValue(), researchData.getOrganism());
						addPoint(targetLPGraphData, 0.0, researchData.getOrganism());
						addPoint(surrogateLPGraphData, 0.0, researchData.getOrganism());
						addPoint(surrogateMPGraphData, 0.0, researchData.getOrganism());
						addPoint(targetMPErrorGraphData, researchData.getVirus_kValue(), researchData.getOrganism(), researchData.getVirus_cl95());
					}
				} else {
					if (researchData.getVirus_uvType() == UvType.LP) { // Add lp point data to graph
						addPoint(surrogateLPGraphData, researchData.getVirus_kValue(), researchData.getOrganism());
						addPoint(surrogateMPGraphData, 0.0, researchData.getOrganism());
						addPoint(targetLPGraphData, 0.0, researchData.getOrganism());
						addPoint(targetMPGraphData, 0.0, researchData.getOrganism());
						addPoint(surrogateLPErrorGraphData, researchData.getVirus_kValue(), researchData.getOrganism(), researchData.getVirus_cl95());
					} else { // Add mp point data to graph
						addPoint(surrogateMPGraphData, researchData.getVirus_kValue(), researchData.getOrganism());
						addPoint(surrogateLPGraphData, 0.0, researchData.getOrganism());
						addPoint(targetLPGraphData, 0.0, researchData.getOrganism());
						addPoint(targetMPGraphData, 0.0, researchData.getOrganism());
						addPoint(surrogateMPErrorGraphData, researchData.getVirus_kValue(), researchData.getOrganism(), researchData.getVirus_cl95());
					}
				}

				if (researchData.getVirus_kValue() + researchData.getVirus_cl95() > max) {
					max = researchData.getVirus_kValue() + researchData.getVirus_cl95();
				}
				
				FlotLabel flotLabel = new FlotLabel(index, researchData.getOrganism());
				if (!yaxisLabels.contains(flotLabel)) {
					yaxisLabels.add(flotLabel);
					index++;
				}
			}
	
			// Add target lp graph to be displayed in a single panel
			FlotGraph graph = new FlotGraph();
			graph.setMaxValue(max * 1.1); // add 10% to size
			graph.setYaxisLabels(yaxisLabels);
			graph.setGraphData(targetLPGraphData);
			graphList.add(graph);

			// Add target mp graph 
			graph = new FlotGraph();
			graph.setMaxValue(max * 1.1); // add 10% to size
			graph.setYaxisLabels(yaxisLabels);
			graph.setGraphData(targetMPGraphData);
			graphList.add(graph);
			
			// Add target lp error graph
			graph = new FlotGraph();
			graph.setGraphData(targetLPErrorGraphData);
			graphList.add(graph);
			
			// Add target mp error graph
			graph = new FlotGraph();
			graph.setGraphData(targetMPErrorGraphData);
			graphList.add(graph);

			// Add surrogate mp error graph
			graph = new FlotGraph();
			graph.setMaxValue(max * 1.1); // add 10% to size
			graph.setYaxisLabels(yaxisLabels);
			graph.setGraphData(surrogateLPGraphData);
			graphList.add(graph);

			// Add surrogate mp graph 
			graph = new FlotGraph();
			graph.setMaxValue(max * 1.1); // add 10% to size
			graph.setYaxisLabels(yaxisLabels);
			graph.setGraphData(surrogateMPGraphData);
			graphList.add(graph);
			
			// Add surrogate lp error graph
			graph = new FlotGraph();
			graph.setGraphData(surrogateLPErrorGraphData);
			graphList.add(graph);
			
			// Add surrogate mp error graph
			graph = new FlotGraph();
			graph.setGraphData(surrogateMPErrorGraphData);
			graphList.add(graph);
			// ****************************

		} else if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getFiltrationType() == FiltrationType.GAC) ||
			(selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){

			Collections.sort(researchDataList, researchDataComparator_avg);

			int index = 0;
			double max = 0;
			
			List<Object> targetGraphData = new ArrayList<Object>();
			List<Object> surrogateGraphData = new ArrayList<Object>();
			List<Object> targetErrorGraphData = new ArrayList<Object>();
			List<Object> surrogateErrorGraphData = new ArrayList<Object>();
			
			for (ResearchData researchData: researchDataList) {
				
				if (researchData.getOrganismTarget()) { // Add target point data to graph
					addPoint(targetGraphData, researchData.getAvg(), researchData.getOrganism());
					addPoint(surrogateGraphData, 0.0, researchData.getOrganism());
					addPoint(targetErrorGraphData, researchData.getAvg(), researchData.getOrganism(), researchData.getAvg_stdDev());
				} else { // add surrogate point data to graph
					addPoint(surrogateGraphData, researchData.getAvg(), researchData.getOrganism());
					addPoint(targetGraphData, 0.0, researchData.getOrganism());
					addPoint(surrogateErrorGraphData, researchData.getAvg(), researchData.getOrganism(), researchData.getAvg_stdDev());
				}
					
				if (researchData.getAvg() + researchData.getAvg_stdDev() > max) {
					max = researchData.getAvg() + researchData.getAvg_stdDev();
				}

				FlotLabel flotLabel = new FlotLabel(index, researchData.getOrganism());
				if (!yaxisLabels.contains(flotLabel)) {
					yaxisLabels.add(flotLabel);
					index++;
				}
			}

			// Add target graph to be displayed in a single panel
			FlotGraph graph = new FlotGraph();
			graph.setMaxValue(max * 1.1); // add 10% to size
			graph.setYaxisLabels(yaxisLabels);
			graph.setGraphData(targetGraphData);
			graphList.add(graph);

			// Add surrogate graph 
			graph = new FlotGraph();
			graph.setMaxValue(max * 1.1); // add 10% to size
			graph.setYaxisLabels(yaxisLabels);
			graph.setGraphData(surrogateGraphData);
			graphList.add(graph);
			
			// Add Target error graph
			graph = new FlotGraph();
			graph.setGraphData(targetErrorGraphData);
			graphList.add(graph);
			
			// Add Surrogate error graph
			graph = new FlotGraph();
			graph.setGraphData(surrogateErrorGraphData);
			graphList.add(graph);
			// ****************************
		}
		
		return graphList;
	}
	
	private List<Object> addPoint(List<Object> list,  Double value, String label) {
		List<Object> point = new ArrayList<Object>();
		point.add(value);
		point.add("\"" + label + "\"");
		list.add(point);
		
		return point;
	}
	
	private List<Object> addPoint(List<Object> list,  Double value, String label, Double errorValue) {
		List<Object> point = new ArrayList<Object>();
		point.add(value);
		point.add("\"" + label + "\"");
		point.add(errorValue);
		list.add(point);
		
		return point;
	}
}
