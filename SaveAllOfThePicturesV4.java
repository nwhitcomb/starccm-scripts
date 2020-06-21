// STAR-CCM+ macro: SaveAllOfThePicturesV4.java
// Written by STAR-CCM+ 15.02.007
package macro;

import java.io.File;
import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;

public class SaveAllOfThePicturesV4 extends StarMacro {

    public void execute() {

        Simulation sim = getActiveSimulation(); //labeling sim as the active simulation

        String sep = System.getProperty("file.separator"); //getting operating system separator
        String filename = sim.getPresentationName(); //getting simulation filename

        AccumulatedForceTable accumulatedForceTable_0 = 
			((AccumulatedForceTable) sim.getTableManager().getTable("Accumulated Downforce Table"));

		accumulatedForceTable_0.extract();

		AccumulatedForceTable accumulatedForceTable_1 = 
			((AccumulatedForceTable) sim.getTableManager().getTable("Accumulated Drag Table"));

			accumulatedForceTable_1.extract();

        for (Scene scene : sim.getSceneManager().getScenes()) { //cycling through scenes
  
            String scenename = scene.getSceneManager().getPresentationName();
            Collection<VisView> views = sim.getViewManager().getObjects(); //getting all views

            Units units = 
  				((Units) sim.getUnitsManager().getObject("m"));

			double z = 0;
			double zp = 0;
			double zm = -0.025;
			double f = -6.75;	     

            for (VisView cv : views) { //cycling through views

                CurrentView currentview = scene.getCurrentView(); //labeling currentview as the current view being processed
                currentview.setView(cv); //changing the view in the scene

                //sim.print("The view being proccessed is named:" + scene + cv);
                scene.open(true); //is the scene open?
                scene.printAndWait(resolvePath("C:\\Users\\nwhit\\Documents\\Simulation\\F20 Full Car Sims\\Reports\\" + filename + " " + scene.getPresentationName() + " " + cv.getPresentationName() + ".jpg"), 1, 3840, 2160);
            
        	}  

			if (scene.getPresentationName().contains("Velocity - Z Planes")) {

			    SceneUpdate sceneUpdate_0 = 
      				scene.getSceneUpdate();

				CurrentView currentView_1 = 
  					scene.getCurrentView();

				VisView visView_0 = 
  					((VisView) sim.getViewManager().getObject("ZPlaneView"));

				currentView_1.setView(visView_0);	

		        ScalarDisplayer scalarDisplayer_0 = 
       			((ScalarDisplayer) scene.getDisplayerManager().getDisplayer("Section Scalar"));

				scalarDisplayer_0.getInputParts().setQuery(null);
		    	
		    	PlaneSection planeSection_0 = 
	    		((PlaneSection) sim.getPartManager().getObject("Z Plane Section (0 mm)"));

				scalarDisplayer_0.getInputParts().setObjects(planeSection_0);

			    while (z < 0.550) {

		    	SingleValue singleValue_0 = 
      				planeSection_0.getSingleValue();

    			singleValue_0.getValueQuantity().setValue(z);

				scene.printAndWait(resolvePath("C:\\Users\\nwhit\\Documents\\Simulation\\F20 Full Car Sims\\Reports\\Z-Plane Views (Velocity)\\" + filename + " " + "(" + z + "m" + ")" + " " + scene.getPresentationName() + " " + scene.getCurrentView().getPresentationName() + ".jpg"), 1, 3840, 2160);
				
				z = z + 0.01375;

				//sim.println(z);
					}
				}

				if (scene.getPresentationName().contains("Pressure - Z Planes")) {

			    SceneUpdate sceneUpdate_0 = 
      				scene.getSceneUpdate();

				CurrentView currentView_1 = 
  					scene.getCurrentView();

				VisView visView_0 = 
  					((VisView) sim.getViewManager().getObject("ZPlaneView"));

				currentView_1.setView(visView_0);	

		        ScalarDisplayer scalarDisplayer_0 = 
       			((ScalarDisplayer) scene.getDisplayerManager().getDisplayer("Section Scalar"));

				scalarDisplayer_0.getInputParts().setQuery(null);
		    	
		    	PlaneSection planeSection_0 = 
	    		((PlaneSection) sim.getPartManager().getObject("Z Plane Section (0 mm)"));

				scalarDisplayer_0.getInputParts().setObjects(planeSection_0);

			    while (zp < 0.550) {

		    	SingleValue singleValue_0 = 
      				planeSection_0.getSingleValue();

    			singleValue_0.getValueQuantity().setValue(zp);

				scene.printAndWait(resolvePath("C:\\Users\\nwhit\\Documents\\Simulation\\F20 Full Car Sims\\Reports\\Z-Plane Views (Pressure)\\" + filename + " " + "(" + zp + "m" + ")" + " " + scene.getPresentationName() + " " + scene.getCurrentView().getPresentationName() + ".jpg"), 1, 3840, 2160);
				
				zp = zp + 0.01375;

				//sim.println(z);
					}
				}

		    	if (scene.getPresentationName().contains("Mesh - Z Planes")) {

	    		SceneUpdate sceneUpdate_1 = 
      				scene.getSceneUpdate();

	    		CurrentView currentView_1 = 
  					scene.getCurrentView();

				VisView visView_0 = 
  					((VisView) sim.getViewManager().getObject("ZPlaneView"));

				currentView_1.setView(visView_0);

		        PartDisplayer partDisplayer_1 = 
     				((PartDisplayer) scene.getDisplayerManager().getDisplayer("Mesh Section"));

				partDisplayer_1.initialize();

			    scene.open();

			    SceneUpdate sceneUpdate_0 = 
		      		scene.getSceneUpdate();
		    	
		    	PlaneSection planeSection_1 = 
	    		((PlaneSection) sim.getPartManager().getObject("Z Plane Section (0 mm)"));

				while (zm < 0.8) {

				SingleValue singleValue_1 = 
      				planeSection_1.getSingleValue();

    			singleValue_1.getValueQuantity().setValue(zm);

				scene.printAndWait(resolvePath("C:\\Users\\nwhit\\Documents\\Simulation\\F20 Full Car Sims\\Reports\\Mesh Z-Plane Views\\" + filename + " " + "(" + zm + "m" + ")" + " " + scene.getPresentationName() + " " + scene.getCurrentView().getPresentationName() + ".jpg"), 1, 3840, 2160);

				zm = zm + 0.01;

				//sim.println(z);
					}
				}*/

				if (scene.getPresentationName().contains("Velocity - X Planes")) {

				SceneUpdate sceneUpdate_2 = 
      				scene.getSceneUpdate();

				CurrentView currentView_1 = 
  					scene.getCurrentView();

				VisView visView_2 = 
    				((VisView) sim.getViewManager().getObject("Front"));

				currentView_1.setView(visView_2);

			    ScalarDisplayer scalarDisplayer_2 = 
		        ((ScalarDisplayer) scene.getDisplayerManager().getDisplayer("Section Scalar"));

		        scalarDisplayer_2.getInputParts().setQuery(null);

			    PlaneSection planeSection_2 = 
			    ((PlaneSection) sim.getPartManager().getObject("X Plane Section"));

    		    scalarDisplayer_2.getInputParts().setObjects(planeSection_2);

				while (f < 1.25) {

				SingleValue singleValue_2 = 
      				planeSection_2.getSingleValue();

    			singleValue_2.getValueQuantity().setValue(f);

				scene.printAndWait(resolvePath("C:\\Users\\nwhit\\Documents\\Simulation\\F20 Full Car Sims\\Reports\\X-Plane Views\\" + filename + " " + "(" + f + "m" + ")" + " " + scene.getPresentationName() + " " + scene.getCurrentView().getPresentationName() + ".jpg"), 1, 3840, 2160);

				f = f + 0.016;

				//sim.println(f);
					} 
            	}


        }

	        for (StarPlot plot : sim.getPlotManager().getObjects()) {
	            plot.encode(resolvePath("C:\\Users\\nwhit\\Documents\\Simulation\\F20 Full Car Sims\\Reports\\Plots\\" + plot.getPresentationName() + ".jpg"), 3840, 2160);
       		}
	}

}
