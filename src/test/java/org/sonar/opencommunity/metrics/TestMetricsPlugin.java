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

import org.junit.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.sonar.api.Plugin.Context;
import org.sonar.opencommunity.measures.BigFunctionsLoCMeasureComputer;
import org.sonar.opencommunity.measures.BigFunctionsLoCPercMeasureComputer;
import org.sonar.opencommunity.measures.BigFunctionsMeasureComputer;
import org.sonar.opencommunity.measures.BigFunctionsPercMeasureComputer;
import org.sonar.opencommunity.measures.ComplexFunctionsLoCMeasureComputer;
import org.sonar.opencommunity.measures.ComplexFunctionsLoCPercMeasureComputer;
import org.sonar.opencommunity.measures.ComplexFunctionsMeasureComputer;
import org.sonar.opencommunity.measures.ComplexFunctionsPercMeasureComputer;
import org.sonar.opencommunity.measures.LoCInFunctionsMeasureComputer;

public class TestMetricsPlugin {
  
  private MetricsPlugin plugin;
  
  @Mock
  private Context context;
  
  @Before
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    this.plugin = new MetricsPlugin();
  }
  
  @Test
  public void whenDefiningShouldRegisterOpenCommunityMetrics(){       
    this.plugin.define(context);
        
    verify(this.context).addExtension(OpenCommunityMetrics.class);                 
    verify(this.context).addExtension(LoCInFunctionsMeasureComputer.class);
    verify(this.context).addExtension(BigFunctionsMeasureComputer.class);
    verify(this.context).addExtension(BigFunctionsPercMeasureComputer.class);
    verify(this.context).addExtension(BigFunctionsLoCMeasureComputer.class);
    verify(this.context).addExtension(BigFunctionsLoCPercMeasureComputer.class);
    verify(this.context).addExtension(ComplexFunctionsMeasureComputer.class);
    verify(this.context).addExtension(ComplexFunctionsPercMeasureComputer.class);
    verify(this.context).addExtension(ComplexFunctionsLoCMeasureComputer.class);
    verify(this.context).addExtension(ComplexFunctionsLoCPercMeasureComputer.class);
  }
}
