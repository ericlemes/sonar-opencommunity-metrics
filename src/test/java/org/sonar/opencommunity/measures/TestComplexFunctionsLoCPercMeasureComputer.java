/**
 * Sonar OpenCommunity Metrics (Community)
 * Copyright (C) 2017 SonarOpenCommunity
 * http://github.com/SonarOpenCommunity/sonar-opencommunity-metrics
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.opencommunity.measures;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.MeasureComputer;
import org.sonar.opencommunity.metrics.OpenCommunityMetrics;

public class TestComplexFunctionsLoCPercMeasureComputer {
 private ComplexFunctionsLoCPercMeasureComputer measureComputer;
  
  @Mock
  private MeasureComputer.MeasureComputerDefinitionContext definitionContext;
  
  @Mock
  private MeasureComputer.MeasureComputerDefinition.Builder definitionContextBuilder;
  
  @Mock
  private MeasureComputer.MeasureComputerContext context;
  
  @Before
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    this.measureComputer = new ComplexFunctionsLoCPercMeasureComputer();
    
    when(this.definitionContext.newDefinitionBuilder()).thenReturn(definitionContextBuilder);
    when(this.definitionContextBuilder.setOutputMetrics(anyString())).thenReturn(this.definitionContextBuilder);
    when(this.definitionContextBuilder.setInputMetrics(anyString(), anyString())).thenReturn(this.definitionContextBuilder);
  }    
  
  @Test
  public void testWhenDefiningShouldReturnCorrectDefinition(){
    this.measureComputer.define(definitionContext);
    verify(this.definitionContextBuilder).setInputMetrics(OpenCommunityMetrics.LOC_IN_FUNCTIONS.key(), OpenCommunityMetrics.COMPLEX_FUNCTIONS_LOC.key());
    verify(this.definitionContextBuilder).setOutputMetrics(OpenCommunityMetrics.COMPLEX_FUNCTIONS_LOC_PERC.key());
    verify(this.definitionContextBuilder).build();
  }
  
  @Test
  public void testWhenCallingComputeShouldComputeCorrectly(){        
    Component file = MeasureComputerTestHelper.setupComponentAndIntMeasure(context, Component.Type.FILE, 100, OpenCommunityMetrics.LOC_IN_FUNCTIONS.key());    
    MeasureComputerTestHelper.addIntMeasure(context, file, 50, OpenCommunityMetrics.COMPLEX_FUNCTIONS_LOC.key());
    this.measureComputer.compute(context);
    
    Component file2 = MeasureComputerTestHelper.setupComponentAndIntMeasure(context, Component.Type.FILE, 25, OpenCommunityMetrics.LOC_IN_FUNCTIONS.key());    
    MeasureComputerTestHelper.addIntMeasure(context, file2, 5, OpenCommunityMetrics.COMPLEX_FUNCTIONS_LOC.key());
    this.measureComputer.compute(context);
    
    MeasureComputerTestHelper.setupProject(context);
    this.measureComputer.compute(context);
    
    verify(context).addMeasure(OpenCommunityMetrics.COMPLEX_FUNCTIONS_LOC_PERC.key(), 44.0d);
   }
  
 @Test
  public void testWhenCallingComputeWithUnexpectedComponentShouldNotAddMeasure(){
    MeasureComputerTestHelper.setupView(context);
    
    this.measureComputer.compute(context);
    verify(context, times(0)).addMeasure(anyString(), anyInt());
  }  
    
  @Test
  public void testWhenCallingComputeWithFileWithNoMeasureShouldNotThrow(){
    MeasureComputerTestHelper.setupComponentAndIntMeasure(context, Component.Type.FILE, 42, OpenCommunityMetrics.COMPLEX_FUNCTIONS.key());    
    when(this.context.getMeasure(OpenCommunityMetrics.COMPLEX_FUNCTIONS.key())).thenReturn(null);
    this.measureComputer.compute(context);
    
    verify(context, times(0)).addMeasure(anyString(), anyInt());
  }
  
  @Test
  public void testWhenCallingComputeWithFileWithNoLoCInFunctionsShouldReturn0(){
    Component file = MeasureComputerTestHelper.setupComponentAndIntMeasure(context, Component.Type.FILE, 0, OpenCommunityMetrics.LOC_IN_FUNCTIONS.key());    
    MeasureComputerTestHelper.addIntMeasure(context, file, 0, OpenCommunityMetrics.COMPLEX_FUNCTIONS.key());   
    this.measureComputer.compute(context);
    
    MeasureComputerTestHelper.setupProject(context);
    this.measureComputer.compute(context);
    
    verify(context).addMeasure(OpenCommunityMetrics.COMPLEX_FUNCTIONS_LOC_PERC.key(), 0d);
  }      
  
}
