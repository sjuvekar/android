package com.ramsud.symc;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphViewStyle.GridStyle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class GraphActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graph);
		
		// init example series data
		GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[] {
		    new GraphView.GraphViewData(1, 2.0d)
		    , new GraphView.GraphViewData(2, 1.5d)
		    , new GraphView.GraphViewData(3, 2.5d)
		    , new GraphView.GraphViewData(4, 1.0d)
		});
		 
		drawGraph(exampleSeries, 
				  "Throat Pain", 
				  new String[]{"Bad", "Moderate", "Managable"}, 
				  R.id.graphThroatPain);
		
		drawGraph(exampleSeries, 
				  "Eating Difficulty", 
				  new String[]{"High", "Moderate", "None"},
				  R.id.graphEatingDifficulty);
		
		BootstrapButton start_button = (BootstrapButton) findViewById(R.id.graphStart);
		start_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent throat_intent = new Intent(getApplicationContext(), ThroatPainActivity.class);
				startActivity(throat_intent);
			}
		});
	}
	
	private void drawGraph(GraphViewSeries series, 
						   String title, 
						   String[] labels, 
						   int layout_id) {
		// Create graphview and setup parameters
		LineGraphView graphView = new LineGraphView(this, title);
		
		// Background color
		graphView.setDrawBackground(true);
		
		// Y-labels
		graphView.setVerticalLabels(labels);
		graphView.setHorizontalLabels(new String[]{""});
		graphView.getGraphViewStyle().setTextSize(getResources().getDimension(R.dimen.text_size_small));
		graphView.getGraphViewStyle().setVerticalLabelsWidth(100);
		
		// Grid lines
		graphView.getGraphViewStyle().setGridStyle(GridStyle.NONE);
		
		// Add Data
		graphView.addSeries(series);
		LinearLayout layout = (LinearLayout) findViewById(layout_id);
		layout.addView(graphView);		
	}
}
