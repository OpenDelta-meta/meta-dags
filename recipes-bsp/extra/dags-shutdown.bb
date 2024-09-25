require conf/license/license-gplv2.inc


SRC_URI = " \
    file://turnoff_power \
    file://dags-shutdown.sh "

INITSCRIPT_NAME = "dags-shutdown"
INITSCRIPT_PARAMS = "start 89 0 ."

inherit pkgconfig update-rc.d

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/dags-shutdown.sh ${D}${sysconfdir}/init.d/dags-shutdown
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/turnoff_power ${D}${bindir}
}

pkg_preinst_${PN}_prepend() {
#!/bin/sh
if [ -z "$D" ]; then
    chmod -x $D${sysconfdir}/init.d/dags-shutdown
fi
}

pkg_postinst_${PN}_append() {
#!/bin/sh
chmod 755 $D${sysconfdir}/init.d/dags-shutdown
}

pkg_prerm_${PN}() {
#!/bin/sh
exit 0
}

COMPATIBLE_MACHINE = "^(force1|force1plus|iqonios100hd|iqonios200hd|iqonios300hd|iqonios300hdv2|mediabox|optimussos1|optimussos1plus|optimussos2|optimussos2plus|optimussos3plus|worldvisionf1|worldvisionf1plus|tm2t|tmnano|tmnano2super|tmnano2t|tmnano3t|tmtwin|tmsingle|force3uhd|force3uhdplus|tm4ksuper|tmtwin4k|lunix34k|galaxy4k|revo4k|force4|lunix4k|force2|force2nano|force2plus|force2plushv|force2se|optimussos|valalinux|tmnanom3|tmnanoseplus|tmnanosem2|tmnanosecombo|tmnanose|lunix|fusionhd|fusionhdse|purehd|purehdse|lunixco)$"
