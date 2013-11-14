package nl.watershare.qmra.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nl.watershare.qmra.entity.ResearchData;
import nl.watershare.qmra.service.SelectionCriteria;

public class ResearchDataResult {

	private SelectionCriteria selectionCriteria = null;
	private List<ResearchData> researchDataList = null;

	Comparator<ResearchData> researchDataComparator_year = new Comparator<ResearchData>() {
	    public int compare(ResearchData rd1, ResearchData rd2) {
	    	int year1 = 0;
	    	int year2 = 0;
	    	
	    	if (rd1.getYear() != null ) {
	    		year1 = rd1.getYear();
	    	}
	    	if (rd2.getYear() != null) {
	    		year2 = rd2.getYear();
	    	}
	    	if (year1 > year2) {
	    		return 1;
	    	} else {
	    		return 0;
	    	}
	    }
	};
	
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

	public ResearchDataResult(SelectionCriteria selectionCriteria, List<ResearchData> researchDataList) {
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
	
	public Double getPercentileYear(Integer percentile) throws PercentileException {
		
		if (researchDataList.size() < 20) {
			throw new PercentileException("Percentile calculation inaccurate due to too small data set");
		}
		
		for (ResearchData researchData: researchDataList) {
			if (researchData.getYear() == null) {
				throw new PercentileException("Percentile calculation inaccurate due to missing year data");
			}
		}
		
		Collections.sort(researchDataList, researchDataComparator_year);
		
		double result = 0;
		if (percentile == 0) {
			result = researchDataList.get(0).getYear();
		} else if (percentile == 100) {
			result = researchDataList.get(researchDataList.size() - 1).getYear();			
		} else {
			double rank = ((percentile.intValue() / 100.0) * (researchDataList.size() - 1)) + 1;
			int k = (int) rank;
			double d = rank - k;
			
			double result_k = researchDataList.get(k - 1).getYear();
			double result_d = (researchDataList.get(k).getYear() - result_k) * d;
			result = result_k + result_d;
		}
		
		return result;
	}
	
	public Integer getStudyCount() {
		
		Integer studyCount = 0;
		
		if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) ||
			(selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){
			
			studyCount = researchDataList.size();
			
		} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getDisinfectionType() == DisinfectionType.UV) {
			
			for (ResearchData researchData: researchDataList) {
				studyCount += researchData.getVirus_studyCount();
			}
		}
		
		return studyCount;
	}
	
	public Integer getStudySampleCount() {
		
		Integer sampleCount = 0;
		
		if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) ||
			(selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){
						
			for (ResearchData researchData: researchDataList) {
				sampleCount += researchData.getSampleCount();
			}
			
		} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getDisinfectionType() == DisinfectionType.UV) {
				
			for (ResearchData researchData: researchDataList) {
				sampleCount += researchData.getVirus_sampleCount();
			}
		}
		
		return sampleCount;
	}
		
	public Double getAverageElimination() {
		
		Double totalDec = 0.0;
		
		if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) ||
			(selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){
			
			
			for (ResearchData researchData: researchDataList) {
				totalDec += researchData.getAvg();
			}
			
		} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getDisinfectionType() == DisinfectionType.UV) {
				
			for (ResearchData researchData: researchDataList) {
				totalDec += researchData.getVirus_kValue();
			}
		}
		
		return totalDec / researchDataList.size();
	}

	public Double getStandardDeviationElimination() {

		double result = 0;
		List<Double> valueList = new ArrayList<Double>();
		
		if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) ||
			(selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){
			
			
			for (ResearchData researchData: researchDataList) {
				valueList.add(researchData.getAvg());
			}
			result = getStandarddDeviation(valueList.toArray(new Double[valueList.size()]));
			
		} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getDisinfectionType() == DisinfectionType.UV) {
					
			for (ResearchData researchData: researchDataList) {
				valueList.add(researchData.getVirus_kValue());
			}
			result = getStandarddDeviation(valueList.toArray(new Double[valueList.size()]));
		}
		
		return result;
	}
	
	public Double getMinimumEliminitation() {
		
		double result = 999999999;
		
		if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) ||
			(selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){
			
			for (ResearchData researchData: researchDataList) {
				if (researchData.getAvg() < result) {
					result = researchData.getAvg();
				}
			}
		} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getDisinfectionType() == DisinfectionType.UV) {
						
			for (ResearchData researchData: researchDataList) {
				if (researchData.getVirus_cl95() < result) {
					result = researchData.getVirus_cl95();
				}
			}
		}
		
		return result;
	}

	public Double getMaximumEliminitation() {
		
		double result = 0;
		
		if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) || 
			(selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){
			
			for (ResearchData researchData: researchDataList) {
				if (researchData.getAvg() > result) {
					result = researchData.getAvg();
				}
			}
		} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getDisinfectionType() == DisinfectionType.UV) {
							
			for (ResearchData researchData: researchDataList) {
				if (researchData.getVirus_cl95() > result) {
					result = researchData.getVirus_cl95();
				}
			}
		}
		
		return result;
	}

	public Double getPercentileElimination(Integer percentile) throws PercentileException {
		
		double result = 0;

		if (researchDataList.size() < 20) {
			throw new PercentileException("Percentile calculation inaccurate due to too small data set");
		}

		if ((selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) ||
			(selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION) ||
			(selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
			selectionCriteria.getProcessType() == ProcessType.FILTRATION)){

			Collections.sort(researchDataList, researchDataComparator_avg);

			if (percentile == 0) {
				result = researchDataList.get(0).getAvg();
			} else if (percentile == 100) {
				result = researchDataList.get(researchDataList.size()).getAvg();			
			} else {
				double rank = ((percentile.intValue() / 100.0) * (researchDataList.size() - 1)) + 1;
				int k = (int) rank;
				double d = rank - k;
				
				double result_k = researchDataList.get(k - 1).getAvg();
				double result_d = (researchDataList.get(k).getAvg() - result_k) * d;
				result = result_k + result_d;
			}
			
		} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
				selectionCriteria.getDisinfectionType() == DisinfectionType.UV) {

			Collections.sort(researchDataList, researchDataComparator_kValue);

			if (percentile == 0) {
				result = researchDataList.get(0).getVirus_cl95();
			} else if (percentile == 100) {
				result = researchDataList.get(researchDataList.size()).getVirus_cl95();			
			} else {
				double rank = ((percentile.intValue() / 100.0) * (researchDataList.size() - 1)) + 1;
				int k = (int) rank;
				double d = rank - k;
				
				double result_k = researchDataList.get(k - 1).getVirus_cl95();
				double result_d = (researchDataList.get(k).getVirus_cl95() - result_k) * d;
				result = result_k + result_d;
			}
		} 
		
		return result;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	private double getMean(Double[] data) {
    	double sum = 0.0;
    	for(double a : data) {
    		sum += a;
    	}
    	return sum / data.length;
	}

	private double getVariance(Double[] data) {
		double mean = getMean(data);
		double temp = 0;
		for(double a : data) {
			temp += (a - mean) * (a - mean);
		}
		return temp / (data.length - 1);
	}

    private double getStandarddDeviation(Double[] data) {
    	return Math.sqrt(getVariance(data));
	}

//    private double median(Double[] data) {
//    	double[] b = new double[data.length];
//    	System.arraycopy(data, 0, b, 0, b.length);
//    	Arrays.sort(b);
//
//    	if (data.length % 2 == 0) {
//    		return (b[(b.length / 2) - 1] + b[b.length / 2]) / 2.0;
//    	} else {
//    		return b[b.length / 2];
//    	}
//	}
	
}
