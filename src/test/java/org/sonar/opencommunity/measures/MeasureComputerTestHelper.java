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

import static org.mockito.Mockito.*;
import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer;
import org.sonar.opencommunity.metrics.OpenCommunityMetrics;

public class MeasureComputerTestHelper {
  
  public static void setupComponentAndIntMeasure(MeasureComputer.MeasureComputerContext context, 
    Component.Type type, int measure){
    
    Component component = mock(Component.class);
    when(component.getType()).thenReturn(type);
    
    Measure measureObj = mock(Measure.class);
    when(measureObj.getIntValue()).thenReturn(measure);
    
    when(context.getComponent()).thenReturn(component);
    when(context.getMeasure(OpenCommunityMetrics.LOC_IN_FUNCTIONS.key())).thenReturn(measureObj);            
  }
  
  public static void setupProject(MeasureComputer.MeasureComputerContext context){
    Component component = mock(Component.class);
    when(component.getType()).thenReturn(Component.Type.PROJECT);
    when(context.getComponent()).thenReturn(component);
  }
  
  public static void setupView(MeasureComputer.MeasureComputerContext context){
    Component component = mock(Component.class);
    when(component.getType()).thenReturn(Component.Type.VIEW);
    when(context.getComponent()).thenReturn(component);
  }
  
}
