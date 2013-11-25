package nl.watershare.qmra.result.graph;


public class FlotGraph {

	private Object xaxisLabels;
	private Object yaxisLabels;	
	private Object graphData;
	private Double minValue;
	private Double maxValue;
	
	public FlotGraph() {
		super();
		this.graphData = null;
	}

	public Object getGraphData() {
		return graphData;
	}
	public void setGraphData(Object graphData) {
		this.graphData = graphData;
	}
	public Object getXaxisLabels() {
		return xaxisLabels;
	}
	public void setXaxisLabels(Object xaxisLabels) {
		this.xaxisLabels = xaxisLabels;
	}
	public Object getYaxisLabels() {
		return yaxisLabels;
	}
	public void setYaxisLabels(Object yaxisLabels) {
		this.yaxisLabels = yaxisLabels;
	}
	public Double getMinValue() {
		return minValue;
	}
	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}
	public Double getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(",");
		
		if (minValue != null) {
			sb.append("[" + minValue + "]");
		} else {
			sb.append("[]");
		}
		sb.append(",");
		
		if (maxValue != null) {
			sb.append("[" + maxValue + "]");
		} else {
			sb.append("[]");
		}
		sb.append(",");
		
		if (xaxisLabels != null) {
			sb.append(xaxisLabels);
		} else {
			sb.append("[]");
		}
		sb.append(",");
		
		if (yaxisLabels != null) {
			sb.append(yaxisLabels);
		} else {
			sb.append("[]");
		}
		sb.append(",");
		
		sb.append(graphData);

		return sb.toString();
	}
}
