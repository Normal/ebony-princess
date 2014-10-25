package com.epam.hackathon.ep.service

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.websocket.server.PathParam

@RestController
class ProjectService {

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    def getAll() {
        [
                [
                        status: 'green',
                        name: 'ВТБ',
                        lat: 55.7592794,
                        lng: 37.629595
                ],
                [
                        status: 'green',
                        name: 'AstralJet',
                        lat: 55.6077115,
                        lng: 37.5443201
                ]
        ]
    }

    @RequestMapping(value = '/projects/{code}', method = RequestMethod.GET)
    def getByCode(@PathVariable String code) {
        [
                [
                        status: 'green',
                        name: 'AstralJet',
                        code: 'AstralJet',
                        employers_locations: [
                                lat: 55.6077115,
                                lng: 37.5443201,
                                num: 100,
                                name: 'spb'
                        ],
                        ep_metrics: [
                                ciExists: true,
                                buildtime: '00:00:10',
                                unitTestCoverage: '80',
                                buildStatus: true,
                                numLocations: 1,
                                criticalCodeVialations: 0
                        ]
                ]
        ].find {it.code == code}
    }
}