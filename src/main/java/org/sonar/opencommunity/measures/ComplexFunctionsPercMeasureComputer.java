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

import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.opencommunity.metrics.OpenCommunityMetrics;

public class ComplexFunctionsPercMeasureComputer implements MeasureComputer {

  @Override
  public MeasureComputerDefinition define(MeasureComputerDefinitionContext context) {
    return context.newDefinitionBuilder()
      .setInputMetrics(OpenCommunityMetrics.COMPLEX_FUNCTIONS.key(), CoreMetrics.FUNCTIONS.key())
      .setOutputMetrics(OpenCommunityMetrics.COMPLEX_FUNCTIONS_PERC.key())
      .build();    
  }

  private int totalComplexFunctions = 0;
  private int totalFunctions = 0;

  @Override
  public void compute(MeasureComputerContext context) {
    if (context.getComponent().getType() == Component.Type.PROJECT){
      context.addMeasure(OpenCommunityMetrics.COMPLEX_FUNCTIONS_PERC.key(), calculatePercentual(totalComplexFunctions, totalFunctions));
    }
    else if (context.getComponent().getType() == Component.Type.FILE){
      Measure m = context.getMeasure(OpenCommunityMetrics.COMPLEX_FUNCTIONS.key());
      if (m != null)
        totalComplexFunctions += m.getIntValue();
      
      m = context.getMeasure(CoreMetrics.FUNCTIONS.key());
      if (m != null)
        totalFunctions += m.getIntValue();
    }    
  }
  
  private double calculatePercentual(int overThreshold, int total) {
    if (total > 0)
      return (((double)overThreshold * 100.0) / total);
    else 
      return 0;
  }
  
}
