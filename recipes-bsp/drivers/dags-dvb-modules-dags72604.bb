require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force4|lunix4k)$"

SRCDATE = "20200717"

SRC_URI[md5sum] = "dff8d9800fbc7c978bc6a0c17ce41838"
SRC_URI[sha256sum] = "a31e45fb03ee2bb22eef8908ce06ce5c5cf303e6c0614a37f5bc6b1effd31ee9"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_72604-${KV}-${SRCDATE}.tar.gz"

do_install() {
		install -d ${D}${nonarch_base_libdir}/modules/${KV}/extra
		for f in ${S}${nonarch_base_libdir}/modules/${KV}/extra/*.ko; do
			install -m 0644 $f ${D}${nonarch_base_libdir}/modules/${KV}/extra;
		done
		install -d ${D}${sysconfdir}/modules-load.d
		for i in `ls ${D}${nonarch_base_libdir}/modules/${KV}/extra | grep \\.ko | sed -e 's/.ko//g'`; do
		    echo $i >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
		done
}
