/**
 * Sonar C++ Plugin (Community)
 * Copyright (C) 2010-2017 SonarOpenCommunity
 * http://github.com/SonarOpenCommunity/sonar-cxx
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
package org.sonarsource.plugins.example.web;

import org.sonar.api.web.page.Context;
import org.sonar.api.web.page.Page;
import org.sonar.api.web.page.Page.Scope;
import org.sonar.api.web.page.PageDefinition;

public class MyPluginPageDefinition implements PageDefinition {

  @Override
  public void define(Context context) {
    context
      .addPage(Page.builder("example/custom_page_4_project")
        .setName("Custom Project Page (Pure JS)")
        .setScope(Scope.COMPONENT).build())
      .addPage(Page.builder("example/measures_history")
        .setName("Custom Project Page using ReactJS")
        .setScope(Scope.COMPONENT).build())

      .addPage(Page.builder("example/custom_page_4_admin")
        .setName("Custom Admin Page")
        .setScope(Scope.GLOBAL)
        .setAdmin(Boolean.TRUE).build())
      .addPage(Page.builder("example/sanity_check")
        .setName("Custom Admin Page Sanity Check")
        .setScope(Scope.GLOBAL)
        .setAdmin(Boolean.TRUE).build())

      .addPage(Page.builder("example/custom_page_global")
        .setName("Custom Global Page")
        .setScope(Scope.GLOBAL).build());
  }
}
