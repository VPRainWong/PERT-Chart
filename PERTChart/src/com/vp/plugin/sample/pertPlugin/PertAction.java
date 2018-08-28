package com.vp.plugin.sample.pertPlugin;

import java.awt.Point;
import java.util.Calendar;


import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.IDiagramUIModel;
import com.vp.plugin.diagram.shape.IPERTLaneUIModel;
import com.vp.plugin.diagram.shape.IPERTTaskUIModel;
import com.vp.plugin.model.IPERTDependency;
import com.vp.plugin.model.IPERTLane;
import com.vp.plugin.model.IPERTTask;
import com.vp.plugin.model.factory.IModelElementFactory;

public class PertAction implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// Create blank diagram
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		IDiagramUIModel pert = (IDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_PERT_CHART);
		pert.setName("Sample PERT Chart");

		// Create Planning Lane
		IPERTLane planning = IModelElementFactory.instance().createPERTLane();
		planning.setName("Planning");
		//display lane on the diagram
		IPERTLaneUIModel shapePlanning = (IPERTLaneUIModel) diagramManager.createDiagramElement(pert, planning);
		shapePlanning.setBounds(0, 0, 1150, 150);
		shapePlanning.resetCaption();
		shapePlanning.setRequestResetCaption(true);

		// Create Tasks on the Planning Lane
		//The task is a child of the Planning Lane
		IPERTTask busAna = planning.createPERTTask();
		busAna.setName("Business Analysis");
		busAna.setTaskId(1);
		//the method getDate() is the method created below
		busAna.setStartDate(getDate(2018, 6, 10));
		busAna.setFinishDate(getDate(2018, 6, 19));
		//display the task on the diagram
		IPERTTaskUIModel shapeBusAna = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, busAna);
		shapeBusAna.setBounds(150, 30, 150, 90);
		shapeBusAna.resetCaption();

		IPERTTask reqEli = planning.createPERTTask();
		reqEli.setName("Requirement Elicitation");
		reqEli.setTaskId(2);
		reqEli.setStartDate(getDate(2018, 6, 19));
		reqEli.setFinishDate(getDate(2018, 7, 5));
		IPERTTaskUIModel shapeReqEli = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, reqEli);
		shapeReqEli.setBounds(350, 30, 150, 90);
		shapeReqEli.resetCaption();

		
		//Create Design Lane
		IPERTLane design = IModelElementFactory.instance().createPERTLane();
		design.setName("Design");
		IPERTLaneUIModel shapeDesign = (IPERTLaneUIModel) diagramManager.createDiagramElement(pert, design);
		shapeDesign.setBounds(0, 150, 1150, 150);
		shapeDesign.resetCaption();
		
		//Create Tasks on the Design Lane
		IPERTTask hiLevDes = design.createPERTTask();
		hiLevDes.setName("High Level Design");
		hiLevDes.setTaskId(3);
		hiLevDes.setStartDate(getDate(2018, 7, 5));
		hiLevDes.setFinishDate(getDate(2018, 7, 11));
		IPERTTaskUIModel shapeHiLevDes = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, hiLevDes);
		shapeHiLevDes.setBounds(350, 180, 150, 90);
		shapeHiLevDes.resetCaption();
		
		IPERTTask detDes = design.createPERTTask();
		detDes.setName("Detailed Design");
		detDes.setTaskId(4);
		detDes.setStartDate(getDate(2018, 7, 11));
		detDes.setFinishDate(getDate(2018, 7, 22));
		IPERTTaskUIModel shapeDetDes = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, detDes);
		shapeDetDes.setBounds(550, 180, 150, 90);
		shapeDetDes.resetCaption();
		
		
		//Create Development & Training Lane
		IPERTLane devNTest = IModelElementFactory.instance().createPERTLane();
		devNTest.setName("Development & Testing");
		IPERTLaneUIModel shapeDevNTest = (IPERTLaneUIModel) diagramManager.createDiagramElement(pert, devNTest);
		shapeDevNTest.setBounds(0, 300, 1150, 300);
		shapeDevNTest.resetCaption();

		//Create Tasks for the Development & Training Lane
		IPERTTask impBackOffSui = devNTest.createPERTTask();
		impBackOffSui.setName("Implement Back Office Suite");
		impBackOffSui.setTaskId(5);
		impBackOffSui.setStartDate(getDate(2018, 7, 22));
		impBackOffSui.setFinishDate(getDate(2018, 8, 06));
		IPERTTaskUIModel shapeImpBackOffSui = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, impBackOffSui);
		shapeImpBackOffSui.setBounds(550, 405, 150, 90);
		shapeImpBackOffSui.resetCaption();
		
		IPERTTask impWebCon = devNTest.createPERTTask();
		impWebCon.setName("Implement Web Content");
		impWebCon.setTaskId(6);
		impWebCon.setStartDate(getDate(2018, 8, 6));
		impWebCon.setFinishDate(getDate(2018, 8, 19));
		IPERTTaskUIModel shapeImpWebCon = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, impWebCon);
		shapeImpWebCon.setBounds(750, 330, 150, 90);
		shapeImpWebCon.resetCaption();
		
		IPERTTask impAndClient = devNTest.createPERTTask();
		impAndClient.setName("Implement Android Client");
		impAndClient.setTaskId(7);
		impAndClient.setStartDate(getDate(2018, 8, 6));
		impAndClient.setFinishDate(getDate(2018, 8, 27));
		IPERTTaskUIModel shapeImpAndClient = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, impAndClient);
		shapeImpAndClient.setBounds(750, 480, 150, 90);
		shapeImpAndClient.resetCaption();
		
		IPERTTask intTesting = devNTest.createPERTTask();
		intTesting.setName("Integration Testing");
		intTesting.setTaskId(8);
		intTesting.setStartDate(getDate(2018, 8, 27));
		intTesting.setFinishDate(getDate(2018, 9, 2));
		IPERTTaskUIModel shapeIntTesting = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, intTesting);
		shapeIntTesting.setBounds(950, 405, 150, 90);
		shapeIntTesting.resetCaption();
		
		
		//Create the Documentation Lane
		IPERTLane documentation = IModelElementFactory.instance().createPERTLane();
		documentation.setName("Documenetation");
		IPERTLaneUIModel shapeDocumentation = (IPERTLaneUIModel) diagramManager.createDiagramElement(pert, documentation);
		shapeDocumentation.setBounds(0, 600, 1150, 150);
		shapeDocumentation.resetCaption();

		//Create tasks for the Documentation Lane
		IPERTTask wriUserMan = documentation.createPERTTask();
		wriUserMan.setName("Write User Manual");
		wriUserMan.setTaskId(9);
		wriUserMan.setStartDate(getDate(2018, 9, 2));
		wriUserMan.setFinishDate(getDate(2018, 9, 23));
		IPERTTaskUIModel shapeWriUserMan = (IPERTTaskUIModel) diagramManager.createDiagramElement(pert, wriUserMan);
		shapeWriUserMan.setBounds(950, 630, 150, 90);
		shapeWriUserMan.resetCaption();
		

		//Create Dependencies
		IPERTDependency busAnaToReqEli = IModelElementFactory.instance().createPERTDependency();
		//The dependency connect from the Business Analysis task...
		busAnaToReqEli.setFrom(busAna);
		//...to the Requirement Elicitation task.
		busAnaToReqEli.setTo(reqEli);
		//Display the dependency on the diagram
		diagramManager.createConnector(pert, busAnaToReqEli, shapeBusAna, shapeReqEli, new Point[] {new Point(300,75), new Point (350,75)});
		
		IPERTDependency reqEliToHiLevDes = IModelElementFactory.instance().createPERTDependency();
		reqEliToHiLevDes.setFrom(reqEli);
		reqEliToHiLevDes.setTo(hiLevDes);
		diagramManager.createConnector(pert, reqEliToHiLevDes, shapeReqEli, shapeHiLevDes, new Point[] {new Point(425,120), new Point(425,180)});
		
		IPERTDependency hiLevDesToDetDes = IModelElementFactory.instance().createPERTDependency();
		hiLevDesToDetDes.setFrom(hiLevDes);
		hiLevDesToDetDes.setTo(detDes);
		diagramManager.createConnector(pert, hiLevDesToDetDes, shapeHiLevDes, shapeDetDes, new Point[] {new Point(500,225), new Point(550,225)});
		
		IPERTDependency detDesToImpBacOffSui = IModelElementFactory.instance().createPERTDependency();
		detDesToImpBacOffSui.setFrom(detDes);
		detDesToImpBacOffSui.setTo(impBackOffSui);
		diagramManager.createConnector(pert, detDesToImpBacOffSui, shapeDetDes, shapeImpBackOffSui, new Point[] {new Point(625,270), new Point(625,405)});
		
		IPERTDependency impBacOffSuiToImpWebCon = IModelElementFactory.instance().createPERTDependency();
		impBacOffSuiToImpWebCon.setFrom(impBackOffSui);
		impBacOffSuiToImpWebCon.setTo(impWebCon);
		diagramManager.createConnector(pert, impBacOffSuiToImpWebCon, shapeImpBackOffSui, shapeImpWebCon, new Point[] {new Point(700,450), new Point(725,450), new Point(725,375), new Point(750,375)});
		
		IPERTDependency impBacOffSuiToImpAndClient = IModelElementFactory.instance().createPERTDependency();
		impBacOffSuiToImpAndClient.setFrom(impBackOffSui);
		impBacOffSuiToImpAndClient.setTo(impAndClient);
		diagramManager.createConnector(pert, impBacOffSuiToImpAndClient, shapeImpBackOffSui, shapeImpAndClient, new Point[] {new Point(700,450), new Point(725,450), new Point(725,525), new Point(750,525)});
		
		IPERTDependency impWebConToIntTesting = IModelElementFactory.instance().createPERTDependency();
		impWebConToIntTesting.setFrom(impWebCon);
		impWebConToIntTesting.setTo(intTesting);
		diagramManager.createConnector(pert, impWebConToIntTesting, shapeImpWebCon, shapeIntTesting, new Point[] {new Point(900,375), new Point(925,375), new Point(925,450), new Point(950,450)});
		
		IPERTDependency impAndClientToIntTesting = IModelElementFactory.instance().createPERTDependency();
		impAndClientToIntTesting.setFrom(impAndClient);
		impAndClientToIntTesting.setTo(intTesting);
		diagramManager.createConnector(pert, impAndClientToIntTesting, shapeImpAndClient, shapeIntTesting, new Point[] {new Point(900,525), new Point(925,525), new Point(925,450), new Point(950,450)});
		
		IPERTDependency intTestingToWriUserMan = IModelElementFactory.instance().createPERTDependency();
		intTestingToWriUserMan.setFrom(intTesting);
		intTestingToWriUserMan.setTo(wriUserMan);
		diagramManager.createConnector(pert, intTestingToWriUserMan, shapeIntTesting, shapeWriUserMan, new Point[] {new Point(1025,495), new Point(1025,630)});
		
		// show up diagram
		diagramManager.openDiagram(pert);
	}

	//this is the private method used in the methods IPERTTask.setStartDate and IPERTTask.setFinishDate
	private String getDate(int year, int month, int date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		//The month starts form 0 for January to 11 for December
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		long longDate = calendar.getTimeInMillis();
		return String.valueOf(longDate);
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub

	}

}
