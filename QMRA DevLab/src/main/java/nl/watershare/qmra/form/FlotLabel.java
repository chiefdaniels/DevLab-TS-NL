package nl.watershare.qmra.form;

public class FlotLabel {

	private int index;
	private String label;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public FlotLabel(int index, String label) {
		super();
		this.index = index;
		this.label = label;
	}

	public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlotLabel)) {
            return false;
        }
        FlotLabel other = (FlotLabel) obj;
        return this.label.equals(other.label);
    }
	
	public int hashCode() {
        return label.hashCode();
    }
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(index);
		sb.append(",");
		sb.append("\"" + label + "\"");
		sb.append("]");
		
		return sb.toString();
	}
	
}
