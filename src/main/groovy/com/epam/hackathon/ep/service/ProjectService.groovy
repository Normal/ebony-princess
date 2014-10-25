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
                        code: 'VTB24',
                        lat: 55.7592794,
                        lng: 37.629595
                ],
                [
                        status: 'green',
                        code: 'AstralJet',
                        lat: 55.6077115,
                        lng: 37.5443201
                ],
                [
                        status: 'red',
                        code: 'Oakley',
                        lat: 41.9100711,
                        lng: 12.5359979
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
                                [
                                        lat: 59.9174455,
                                        lng: 30.3250575,
                                        num: 100,
                                        name: 'St.Petersburg'
                                ],
                                [
                                        lat: 53.7876357,
                                        lng: 30.0768751,
                                        nam: 30,
                                        name: 'Магілёў'
                                ],
                                [
                                        lat: 47.5400415,
                                        lng: 19.1633755,
                                        nam: 15,
                                        name: 'Budapest'
                                ]
                        ],
                        ep_metrics: [
                                ciExists: true,
                                buildTime: '1:15'.randomizeBuildDate(),
                                unitTestsCoverage: 80,
                                buildStatus: true.randomizeWithProbability(10),
                                numLocations: 3,
                                criticalCodeViolations: 0
                        ]
                ],
                [
                        status: 'green',
                        name: 'ВТБ',
                        code: 'VTB24',
                        employers_locations: [
                                [
                                        lat: 53.38704,
                                        lng: 49.9861132,
                                        num: 20,
                                        name: 'Тольятти'
                                ],
                                [
                                        lat: 59.9174455,
                                        lng: 30.3250575,
                                        num: 100,
                                        name: 'St.Petersburg'
                                ],
                                [
                                        lat: 50.3413413,
                                        lng: 30.5129543,
                                        num: 15,
                                        name: 'Київ'
                                ]
                        ],
                        ep_metrics: [
                                ciExists: true,
                                buildTime: '01:10'.randomizeBuildDate(),
                                unitTestsCoverage: 80,
                                buildStatus: true.randomizeWithProbability(10),
                                numLocations: 3,
                                criticalCodeViolations: 1
                        ]
                ],
                [
                        status: 'red',
                        name: 'Oakley',
                        code: 'Oakley',
                        employers_locations: [
                                [
                                        lat: 59.9174455,
                                        lng: 30.3250575,
                                        num: 100,
                                        name: 'St.Petersburg'
                                ],
                        ],
                        ep_metrics: [
                                ciExists: false,
                                buildTime: '15:10'.randomizeBuildDate(),
                                unitTestsCoverage: 20,
                                buildStatus: false,
                                numLocations: 4,
                                criticalCodeViolations: 60
                        ]
                ]

        ].find { it.code == code }
    }
}
