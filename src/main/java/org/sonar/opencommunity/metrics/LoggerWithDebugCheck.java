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

import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.LoggerLevel;
import org.sonar.api.utils.log.Loggers;

public class LoggerWithDebugCheck implements Logger {   
  
  private Logger internalLogger;
  
  public LoggerWithDebugCheck(Logger internalLogger){
    this.internalLogger = internalLogger;
  }
  
  public LoggerWithDebugCheck(Class<?> name){
    this.internalLogger = Loggers.get(name);
  }
  
  public static Logger get(Class<?> name){
    return new LoggerWithDebugCheck(name);
  }

  @Override
  public boolean isTraceEnabled() {
    return internalLogger.isTraceEnabled();
  }

  @Override
  public void trace(String string) {
    internalLogger.trace(string);
  }

  @Override
  public void trace(String string, Object o) {
    internalLogger.trace(string, o);
  }

  @Override
  public void trace(String string, Object o, Object o1) {
    internalLogger.trace(string, o, o1);
  }

  @Override
  public void trace(String string, Object... os) {
    internalLogger.trace(string, os);
  }

  @Override
  public boolean isDebugEnabled() {
    return internalLogger.isDebugEnabled();
  }

  @Override
  public void debug(String string) {
    if (isDebugEnabled())      
      internalLogger.debug(string);
  }

  @Override
  public void debug(String string, Object o) {
    if (isDebugEnabled())      
      internalLogger.debug(string, o);
  }

  @Override
  public void debug(String string, Object o, Object o1) {
    if (isDebugEnabled())      
      internalLogger.debug(string, o, o1);
  }

  @Override
  public void debug(String string, Object... os) {
    if (isDebugEnabled())      
      internalLogger.debug(string, os);
  }

  @Override
  public void info(String string) {
    internalLogger.info(string);
  }

  @Override
  public void info(String string, Object o) {
    internalLogger.info(string, o);
  }

  @Override
  public void info(String string, Object o, Object o1) {
    internalLogger.info(string, o, o1);
  }

  @Override
  public void info(String string, Object... os) {
    internalLogger.info(string, os);
  }

  @Override
  public void warn(String string) {
    internalLogger.warn(string);
  }

  @Override
  public void warn(String string, Throwable thrwbl) {
    internalLogger.warn(string, thrwbl);
  }

  @Override
  public void warn(String string, Object o) {
    internalLogger.warn(string, o);
  }

  @Override
  public void warn(String string, Object o, Object o1) {
    internalLogger.warn(string, o, o1);
  }

  @Override
  public void warn(String string, Object... os) {
    internalLogger.warn(string, os);
  }

  @Override
  public void error(String string) {
    internalLogger.error(string);
  }

  @Override
  public void error(String string, Object o) {
    internalLogger.error(string, o);
  }

  @Override
  public void error(String string, Object o, Object o1) {
    internalLogger.error(string, o, o1);
  }

  @Override
  public void error(String string, Object... os) {
    internalLogger.error(string, os);
  }

  @Override
  public void error(String string, Throwable thrwbl) {
    internalLogger.error(string, thrwbl);
  }

  @Override
  public boolean setLevel(LoggerLevel level) {
    return internalLogger.setLevel(level);
  }

  @Override
  public LoggerLevel getLevel() {
    return internalLogger.getLevel();
  }
  
}
