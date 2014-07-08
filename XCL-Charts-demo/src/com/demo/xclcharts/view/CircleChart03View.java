package com.demo.xclcharts.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.xclcharts.chart.CircleChart;
import org.xclcharts.chart.PieData;
import org.xclcharts.renderer.XChart;
import org.xclcharts.renderer.XEnum;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;

public class CircleChart03View extends GraphicalView {

	private String TAG = "CircleChart01View";
	private CircleChart chart = new CircleChart();	
	
	private List<PieData> mlPieData = new LinkedList<PieData>();		
	private String mDataInfo = "";
	
	public CircleChart03View(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setPercentage(0);	
		chartRender();
	}
	
	 public CircleChart03View(Context context, AttributeSet attrs){   
	        super(context, attrs);   
	        setPercentage(0);	
			chartRender();
	 }
	 
	 
			
	public void chartRender()
	{
		try {						
			
			/*
			//图所占范围大小			
			if(getScreenWidth() < this.getScreenHeight())
			{
				chart.setChartRange(0.0f, 0.0f,getScreenWidth(),getScreenWidth());
			}else{
				chart.setChartRange(0.0f, 0.0f,getScreenHeight(),getScreenHeight());
			}
			*/
						
		
			//设置附加信息
			chart.setAttributeInfo(mDataInfo); 	
			//图的内间距
			chart.setPadding(20, 20, 15, 15);		
			
			//半圆方式显示
			chart.setCircleType(XEnum.CircleType.HALF);	
			
			//设置图表数据源			
			chart.setDataSource(mlPieData);				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//百分比
	public void setPercentage(int per)
	{						
		if(per < 50)
		{
			mDataInfo = "轻松搞定";
			chart.getLabelPaint().setColor(Color.WHITE);
			chart.getPaintDataInfo().setColor(Color.WHITE);
			
		}else if(per < 70){
			mDataInfo = "充满活力";
			chart.getLabelPaint().setColor((int)Color.rgb(72, 201, 176));
			chart.getPaintDataInfo().setColor(Color.WHITE);
		}else{
			mDataInfo = "不堪重负";
			chart.getLabelPaint().setColor(Color.RED);
			chart.getPaintDataInfo().setColor(Color.RED);
		}
		//PieData(标签，百分比，在饼图中对应的颜色)
		mlPieData.clear();		
		mlPieData.add(new PieData(Integer.toString(per)+"%",per,(int)Color.rgb(72, 201, 176)));		
	}

	@Override
    public void render(Canvas canvas) {
        try{
        	canvas.drawColor(Color.GRAY);
        	
        	 //设置图表大小
	        chart.setChartRange(10f, 10f,  
	        		this.getLayoutParams().width - 10,
	        		 this.getLayoutParams().height - 10);
	        //设置绘图区内边距
	        chart.setPadding(120, 180, 100, 100);	        
	        
            chart.render(canvas);
        } catch (Exception e){
        	Log.e(TAG, e.toString());
        }
    }

	
}
