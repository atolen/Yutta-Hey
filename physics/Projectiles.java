public class Projectiles extends Question {
    private Double dx;//displacement in x direction
    private Double dy;//displacement in y direction
    
    private Double vi;//init velocity
    private Double vix;//init velocity -- x component
    private Double viy;//init velocity -- y component

    //assume objects don't accelerate in x direction
    private Double vfy;//final belocity -- y direction

    private Double angle;//angle at which object is thrown
    //                   positive x axis used as reference frame

    //assume objects don't accelerate in x direction
    private Double ay;//acceleration -- y component
    
    private Double t;//time
      
    public String toString() {
	return vars.toString();
    }
    
    // constructors
    public Projectiles() {
	numVars = 9;
	populate();
	d = vars.get("d");
	vi = vars.get("vi");
	vf = vars.get("vf");
	a = vars.get("a");
	t = vars.get("t");
    }

    //populate()
    public void populate() {
	varList.add("d");
	varList.add("vi");
	varList.add("vf");
	varList.add("a");
	varList.add("t");
	assignVals(0,10,0);
    }

    
    //========================CALCULATOR========================

    //finds rightAns
    public String calculate() {
       	while( vars.containsValue(null)) 
	    whichFxn();
	return unknowns.toString();
    }

    public void whichFxn() {
	if( d == null && !(vi == null) && a != null ) { //kin5,kin12 find d
	    if( t != null ) {
		unknowns.put("d",kin5()); //kin5
		vars.put("d",kin5());
	    }
	    else {
		unknowns.put("d",kin12()); //kin12
		vars.put("d",kin12());
	    }
	    return;
	}

	else if( vi == null ) {
	    if( t != null ) {
		if( vf != null ) {
		    unknowns.put("vi",kin3()); //kin3
		    vars.put("vi",kin3());
		}
		else {
		    unknowns.put("vi",kin6()); //kin6
		    vars.put("vi",kin6());
		}
	    }
	    else {
		unknowns.put("vi",kin10()); //kin10
		vars.put("vi",kin10());
	    }
	    return;
	}

	else if( vf == null ) {
	    if( t != null ) {
		unknowns.put("vf",kin2());
		vars.put("vf",kin2());
	    }
	    else {
		unknowns.put("vf",kin9());
		vars.put("vf",kin9());
	    }
	    return;
	}

	else if( a == null ) {
	    if( vi != null && t != null ) {
		if( d == null ) {
		    unknowns.put("a",kin1());
		    vars.put("a",kin1());
		}
		else {
		    unknowns.put("a",kin8());
		    vars.put("a",kin8());
		}
	    }
	    else {
		unknowns.put("a",kin11());
		vars.put("a",kin11());
	    }
	    return;
	}
	    
	else { // t unknown
	    if( vf != null ) {
		unknowns.put("t",kin4());
		vars.put("t",kin4());
	    }
	    else {
		unknowns.put("t",kin7());
		vars.put("t",kin7());
	    }
	    return;
	}
    }

    //===============a = (vf - vi)/t DERIVED===============

    //a = (vf - vi)/t >> if vf, vi, t are known
    public double kin1() {
	return (vf - vi) / t;
    }

    //vf = vi + at  >> if vi, a, t are known
    public double kin2() {
	return vi + (a*t);
    }

    //vi = at - vf >> if a, t, vf are known
    public double kin3() {
	return a*t - vf;
    }

    //t = (vf - vi)/a >> if vf, vi, a are known
    public double kin4() {
	return (vf - vi) / a;
    }

    //============d = vit + (0.5)at^2 DERIVED=========

    //d = vit + (0.5)at^2 >> if vi, t, a are known
    public double kin5() {
	return (vi*t) + ((0.5)*a*Math.pow(t,2));
    }

    //vi = (d - (0.5)at^2)/t >> if d, a, t are known
    public double kin6() {
	return (d - 0.5*a*Math.pow(t,2)) / t;
    }

    //t = sqrt(2d/a) >> if d, a are known, vi == 0
    public double kin7() {
	return Math.sqrt((2*d)/a);
    }

    //a = (2(d - vit))/t^2 >> if d, vi, t are known
    public double kin8() {
	return (2*(d - vi*t)) / Math.pow(vi,2);
    }
    //================================================

    //============vf^2 = vi^2 + 2ad DERIVED=========

    //vf = sqrt(vi^2 + 2ad) >> if vi, a, d are known
    public double kin9() {
	return Math.sqrt(Math.pow(vi,2) + 2*a*d);
    }

    //vi = sqrt(vf^2 - 2ad) >> if vf, a, d are known
    public double kin10() {
	return Math.sqrt(Math.pow(vf,2) - 2*a*d);
    }

    //a = (vf^2 - vi^2) / 2d >> if vf, vi, d are known
    public double kin11() {
	return (Math.pow(vf,2) - Math.pow(vi,2)) / (2*d);
    }

    //d = (vf^2 - vi^2) / 2a >> if vf, vi, a are known
    public double kin12() {
	return (Math.pow(vf,2) - Math.pow(vi,2)) / (2*a);
    }
    //================================================


    public static void main( String[] args ) {
	Kinematics luke = new Kinematics();
	System.out.println(luke);
	System.out.println(luke.calculate());
    }
    
} // close class Kinematics
 