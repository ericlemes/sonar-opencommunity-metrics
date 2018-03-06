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

import java.util.List;
import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.sonar.api.Plugin.Context;

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
    
    ArgumentCaptor<Object> captor = ArgumentCaptor.forClass(Object.class);
    verify(this.context).addExtension(captor.capture());
    
    List extensionList = ((List)captor.getValue());
    
    assertEquals(1, extensionList.size());
    assertEquals(OpenCommunityMetrics.class, extensionList.get(0));
  }
}
