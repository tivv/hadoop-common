/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.hadoop.yarn.api.records.impl.pb;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.yarn.api.records.Container;
import org.apache.hadoop.yarn.api.records.ContainerId;
import org.apache.hadoop.yarn.api.records.ContainerState;
import org.apache.hadoop.yarn.api.records.ContainerStatus;
import org.apache.hadoop.yarn.api.records.ContainerToken;
import org.apache.hadoop.yarn.api.records.ProtoBase;
import org.apache.hadoop.yarn.api.records.Resource;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerIdProto;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerProto;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerProtoOrBuilder;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerStateProto;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerStatusProto;
import org.apache.hadoop.yarn.proto.YarnProtos.ContainerTokenProto;
import org.apache.hadoop.yarn.proto.YarnProtos.ResourceProto;
import org.apache.hadoop.yarn.util.ProtoUtils;


    
public class ContainerPBImpl extends ProtoBase<ContainerProto> implements Container {

  ContainerProto proto = ContainerProto.getDefaultInstance();
  ContainerProto.Builder builder = null;
  boolean viaProto = false;
  
  private ContainerId containerId = null;
  private Resource resource = null;
  private ContainerToken containerToken = null;
  private ContainerStatus containerStatus = null;
  
  public ContainerPBImpl() {
    builder = ContainerProto.newBuilder();
  }

  public ContainerPBImpl(ContainerProto proto) {
    this.proto = proto;
    viaProto = true;
  }
  
  public ContainerProto getProto() {
  
    mergeLocalToProto();
    proto = viaProto ? proto : builder.build();
    viaProto = true;
    return proto;
  }

  private void mergeLocalToBuilder() {
    if (this.containerId != null
        && !((ContainerIdPBImpl) containerId).getProto().equals(
            builder.getId())) {
      builder.setId(convertToProtoFormat(this.containerId));
    }
    if (this.resource != null
        && !((ResourcePBImpl) this.resource).getProto().equals(
            builder.getResource())) {
      builder.setResource(convertToProtoFormat(this.resource));
    }
    if (this.containerToken != null
        && !((ContainerTokenPBImpl) this.containerToken).getProto().equals(
            builder.getContainerToken())) {
      builder.setContainerToken(convertToProtoFormat(this.containerToken));
    }
    if (this.containerStatus != null
        && !((ContainerStatusPBImpl) this.containerStatus).getProto().equals(
            builder.getContainerStatus())) {
      builder.setContainerStatus(convertToProtoFormat(this.containerStatus));
    }
  }

  private void mergeLocalToProto() {
    if (viaProto) 
      maybeInitBuilder();
    mergeLocalToBuilder();
    proto = builder.build();
    viaProto = true;
  }

  private void maybeInitBuilder() {
    if (viaProto || builder == null) {
      builder = ContainerProto.newBuilder(proto);
    }
    viaProto = false;
  }
    
  
  @Override
  public ContainerState getState() {
    ContainerProtoOrBuilder p = viaProto ? proto : builder;
    if (!p.hasState()) {
      return null;
    }
    return convertFromProtoFormat(p.getState());
  }

  @Override
  public void setState(ContainerState state) {
    maybeInitBuilder();
    if (state == null) {
      builder.clearState();
      return;
    }
    builder.setState(convertToProtoFormat(state));
  }
  @Override
  public ContainerId getId() {
    ContainerProtoOrBuilder p = viaProto ? proto : builder;
    if (this.containerId != null) {
      return this.containerId;
    }
    if (!p.hasId()) {
      return null;
    }
    this.containerId = convertFromProtoFormat(p.getId());
    return this.containerId;
  }

  @Override
  public void setId(ContainerId id) {
    maybeInitBuilder();
    if (id == null)
      builder.clearId();
    this.containerId = id;
  }
  @Override
  public String getContainerManagerAddress() {
    ContainerProtoOrBuilder p = viaProto ? proto : builder;
    if (!p.hasContainerManagerAddress()) {
      return null;
    }
    return (p.getContainerManagerAddress());
  }

  @Override
  public void setContainerManagerAddress(String containerManagerAddress) {
    maybeInitBuilder();
    if (containerManagerAddress == null) {
      builder.clearContainerManagerAddress();
      return;
    }
    builder.setContainerManagerAddress((containerManagerAddress));
  }

  @Override
  public String getNodeHttpAddress() {
    ContainerProtoOrBuilder p = viaProto ? proto : builder;
    if (!p.hasNodeHttpAddress()) {
      return null;
    }
    return (p.getNodeHttpAddress());
  }

  @Override
  public void setNodeHttpAddress(String nodeHttpAddress) {
    maybeInitBuilder();
    if (nodeHttpAddress == null) {
      builder.clearNodeHttpAddress();
      return;
    }
    builder.setNodeHttpAddress(nodeHttpAddress);
  }

  @Override
  public Resource getResource() {
    ContainerProtoOrBuilder p = viaProto ? proto : builder;
    if (this.resource != null) {
      return this.resource;
    }
    if (!p.hasResource()) {
      return null;
    }
    this.resource = convertFromProtoFormat(p.getResource());
    return this.resource;
  }

  @Override
  public void setResource(Resource resource) {
    maybeInitBuilder();
    if (resource == null)
      builder.clearResource();
    this.resource = resource;
  }
  @Override
  public ContainerToken getContainerToken() {
    ContainerProtoOrBuilder p = viaProto ? proto : builder;
    if (this.containerToken != null) {
      return this.containerToken;
    }
    if (!p.hasContainerToken()) {
      return null;
    }
    this.containerToken = convertFromProtoFormat(p.getContainerToken());
    return this.containerToken;
  }

  @Override
  public void setContainerToken(ContainerToken containerToken) {
    maybeInitBuilder();
    if (containerToken == null) 
      builder.clearContainerToken();
    this.containerToken = containerToken;
  }

  @Override
  public ContainerStatus getContainerStatus() {
    ContainerProtoOrBuilder p = viaProto ? proto : builder;
    if (this.containerStatus != null) {
      return this.containerStatus;
    }
    if (!p.hasContainerStatus()) {
      return null;
    }
    this.containerStatus = convertFromProtoFormat(p.getContainerStatus());
    return this.containerStatus;
  }

  @Override
  public void setContainerStatus(ContainerStatus containerStatus) {
    maybeInitBuilder();
    if (containerStatus == null) 
      builder.clearContainerStatus();
    this.containerStatus = containerStatus;
  }

  private ContainerStateProto convertToProtoFormat(ContainerState e) {
    return ProtoUtils.convertToProtoFormat(e);
  }

  private ContainerState convertFromProtoFormat(ContainerStateProto e) {
    return ProtoUtils.convertFromProtoFormat(e);
  }

  private ContainerIdPBImpl convertFromProtoFormat(ContainerIdProto p) {
    return new ContainerIdPBImpl(p);
  }

  private ContainerIdProto convertToProtoFormat(ContainerId t) {
    return ((ContainerIdPBImpl)t).getProto();
  }

  private ResourcePBImpl convertFromProtoFormat(ResourceProto p) {
    return new ResourcePBImpl(p);
  }

  private ResourceProto convertToProtoFormat(Resource t) {
    return ((ResourcePBImpl)t).getProto();
  }

  private ContainerTokenPBImpl convertFromProtoFormat(ContainerTokenProto p) {
    return new ContainerTokenPBImpl(p);
  }

  private ContainerTokenProto convertToProtoFormat(ContainerToken t) {
    return ((ContainerTokenPBImpl)t).getProto();
  }

  private ContainerStatusPBImpl convertFromProtoFormat(ContainerStatusProto p) {
    return new ContainerStatusPBImpl(p);
  }

  private ContainerStatusProto convertToProtoFormat(ContainerStatus t) {
    return ((ContainerStatusPBImpl)t).getProto();
  }

  //TODO Comparator
  @Override
  public int compareTo(Container other) {
    if (this.getId().compareTo(other.getId()) == 0) {
      if (this.getContainerManagerAddress().compareTo(other.getContainerManagerAddress()) == 0) {
        if (this.getResource().compareTo(other.getResource()) == 0) {
          if (this.getState().compareTo(other.getState()) == 0) {
            //ContainerToken
            return this.getState().compareTo(other.getState());
          } else {
            return this.getState().compareTo(other.getState());
          }
        } else {
          return this.getResource().compareTo(other.getResource());
        }
      } else {
        return this.getContainerManagerAddress().compareTo(other.getContainerManagerAddress());
      }
    } else {
      return this.getId().compareTo(other.getId());
    }
  }
}  