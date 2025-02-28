/*
 * Etisalat Egypt, Open Source
 * Copyright 2021, Etisalat Egypt and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

/**
 * @author Ayman ElSherif
 */

package com.rodan.intruder.ss7.gateway.fowrarderpayload.mobility;

import com.rodan.intruder.ss7.entities.payload.mobility.IsdForwarderPayload;
import lombok.Builder;
import lombok.Getter;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.InsertSubscriberDataRequest;

// TODO SS7: Which package to add this class to?
public class IsdForwarderPayloadImpl extends IsdForwarderPayload {
    @Getter private InsertSubscriberDataRequest request;

    @Builder(builderMethodName = "forwarderBuilder")
    public IsdForwarderPayloadImpl(IsdForwarderPayload payload, InsertSubscriberDataRequest request) {
        super(payload.getLocalGt(), payload.getUsage(), payload.getImsi(),
                payload.getMsisdn(), payload.getForwardMsisdn(), payload.getGsmScf(), payload.getTargetVlrGt(),
                payload.getBarred(), payload.getSpoofHlr(), payload.getTargetHlrGt(), payload.getMapVersion());
        this.request = request;
    }
}
