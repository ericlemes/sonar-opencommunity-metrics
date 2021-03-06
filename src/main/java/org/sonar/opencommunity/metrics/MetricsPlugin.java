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

package org.sonar.opencommunity.metrics;

import java.util.ArrayList;
import java.util.List;
import org.sonar.api.Plugin;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;
import org.sonar.opencommunity.measures.BigFunctionsLoCMeasureComputer;
import org.sonar.opencommunity.measures.BigFunctionsLoCPercMeasureComputer;
import org.sonar.opencommunity.measures.BigFunctionsMeasureComputer;
import org.sonar.opencommunity.measures.BigFunctionsPercMeasureComputer;
import org.sonar.opencommunity.measures.ComplexFunctionsLoCMeasureComputer;
import org.sonar.opencommunity.measures.ComplexFunctionsLoCPercMeasureComputer;
import org.sonar.opencommunity.measures.ComplexFunctionsMeasureComputer;
import org.sonar.opencommunity.measures.ComplexFunctionsPercMeasureComputer;
import org.sonar.opencommunity.measures.LoCInFunctionsMeasureComputer;

public class MetricsPlugin implements Plugin{
  
  private final Logger LOG = LoggerWithDebugCheck.get(MetricsPlugin.class); 

  @Override
  public void define(Context context) {    
    LOG.debug("Registering OpenCommunityMetrics");       
    
    context.addExtension(OpenCommunityMetrics.class);
    context.addExtension(LoCInFunctionsMeasureComputer.class);
    context.addExtension(BigFunctionsMeasureComputer.class);
    context.addExtension(BigFunctionsLoCMeasureComputer.class);
    context.addExtension(BigFunctionsPercMeasureComputer.class);
    context.addExtension(BigFunctionsLoCPercMeasureComputer.class);
    context.addExtension(ComplexFunctionsMeasureComputer.class);
    context.addExtension(ComplexFunctionsLoCMeasureComputer.class);
    context.addExtension(ComplexFunctionsPercMeasureComputer.class);
    context.addExtension(ComplexFunctionsLoCPercMeasureComputer.class);
  }
}
