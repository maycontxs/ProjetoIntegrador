package depreciar.com;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import bens.com.Ben;

@ManagedBean(name = "Depre")
@SessionScoped

public class BeanBen implements Serializable {

	private static final long serialVersionUID = 1L;

	Ben ben = new Ben();

	private Date dataInic;
	private Date dataFinal;

	@SuppressWarnings("deprecation")
	public int dataDiff() {
		Date d1 = null;
		Date d2 = null;
		dataInic = d1;
		dataFinal = d2;

		int meses = 0;

		if ((dataFinal.getYear() - dataInic.getYear()) > 1) {
			if (dataInic.getDay() > 15) {
				meses = meses + ((dataFinal.getYear() - dataInic.getYear()) * 12);
				meses = 12 - dataInic.getMonth();
				meses = meses + dataFinal.getMonth();
				meses--;
				if(dataFinal.getDay()<15) {
					meses--;					
				}
			} else {
				meses = meses + ((dataFinal.getYear() - dataInic.getYear()) * 12);
				meses = 12 - dataInic.getMonth();
				meses = meses + dataFinal.getMonth();
				if(dataFinal.getDay()<15) {
					meses--;					
				}
			}
		} else {
			if (dataInic.getDay() > 15) {
				meses = 12 - dataInic.getMonth();
				meses = meses + dataFinal.getMonth();
				meses--;
			} else {
				meses = 12 - dataInic.getMonth();
				meses = meses + dataFinal.getMonth();
			}
			if(dataFinal.getDay()<15) {
				meses--;					
			}
		}
		return meses;
	}


	public double depre(double cb, double vr, double taxa) {
		
		double da = (((cb -vr)*taxa)/12)*dataDiff();
		
		double vc = cb - da;
		
		double gp = vc - da;
		
		return gp;
	}
	
}
