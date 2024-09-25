DESCRIPTION = "Linux kernel for ${MACHINE}"
LICENSE = "GPLv2"
SECTION = "kernel"
LIC_FILES_CHKSUM = "file://${WORKDIR}/linux/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(force4|lunix4k)$"

DATETIME = "20180321"

inherit kernel machine_kernel_pr samba_change_dialect

SRC_URI[md5sum] = "710b7af46d7ac1c78e3ef683c5c0a6ad"
SRC_URI[sha256sum] = "1bb6b4f0d559885b3bd5f18c66a50a8ff39a284a81ad4da16188d08b9461ec55"

SRC_URI = "http://en3homeftp.net/pub/down/linux-${KV}-${DATETIME}.tar.xz \
	file://defconfig \
	file://${OPENVISION_BASE}/meta-openvision/recipes-linux/kernel-patches/kernel-add-support-for-gcc${VISIONGCCVERSION}.patch \
	file://0002-log2-give-up-on-gcc-constant-optimizations.patch \
	file://0003-uaccess-dont-mark-register-as-const.patch \
	"

S = "${WORKDIR}/linux"
B = "${WORKDIR}/build"

export OS = "Linux"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OUTPUT = "arch/${ARCH}/boot/${KERNEL_IMAGETYPE}"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGEDEST = "tmp"

FILES_${KERNEL_PACKAGE_NAME}-image = "/${KERNEL_IMAGEDEST}/zImage"

kernel_do_install_append() {
        install -d ${D}/${KERNEL_IMAGEDEST}
        install -m 0755 ${KERNEL_OUTPUT} ${D}/${KERNEL_IMAGEDEST}
}

kernel_do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
        oe_runmake ${KERNEL_IMAGETYPE_FOR_MAKE} ${KERNEL_ALT_IMAGETYPE} CC="${KERNEL_CC}" LD="${KERNEL_LD}"
}

pkg_postinst_${KERNEL_PACKAGE_NAME}-image () {
        if [ -d /proc/stb ] ; then
                dd if=/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} of=/dev/${MTD_KERNEL}
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
        true
}

pkg_postrm_${KERNEL_PACKAGE_NAME}-image () {
}

do_rm_work() {
}
