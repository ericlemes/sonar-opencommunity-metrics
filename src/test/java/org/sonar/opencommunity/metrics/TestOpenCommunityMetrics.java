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

import static org.junit.Assert.*;
import org.junit.*;

public class TestOpenCommunityMetrics {
  
  private OpenCommunityMetrics metrics;
  
  @Before
  public void setUp(){
    this.metrics = new OpenCommunityMetrics();
  }
  
  @Test
  public void testWhenGetMetricsShouldReturnExpectedMetricsCount(){    
    assertEquals(9, metrics.getMetrics().size());
  }
}
