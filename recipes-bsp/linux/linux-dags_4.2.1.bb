SUMMARY = "Linux kernel for ${MACHINE}"
LICENSE = "GPLv2"
SECTION = "kernel"
LIC_FILES_CHKSUM = "file://${WORKDIR}/linux-${PV}/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(force2|force2nano|force2plus|force2plushv|force2se|optimussos|valalinux|tmnanom3|tmnanoseplus|tmnanosem2|tmnanosecombo|tmnanose|lunix|fusionhd|fusionhdse|purehd|purehdse|lunixco)$"

SRCDATE = "20151022"

inherit kernel machine_kernel_pr samba_change_dialect

SRC_URI[md5sum] = "48d1c96b3bedcc6a11c34eede6e36bfd"
SRC_URI[sha256sum] = "ed11d537b1e19d59b132fd643bebc7469bf20e115bdc23e949e2ce14ae53aadc"

SRC_URI = "http://en3homeftp.net/pub/src/dags-linux-${PV}-${SRCDATE}.tar.gz \
	file://defconfig \
	file://${OPENVISION_BASE}/meta-openvision/recipes-linux/kernel-patches/kernel-add-support-for-gcc${VISIONGCCVERSION}.patch \
	file://0002-add-brcm-chips.patch \
	file://0001-Support-TBS-USB-drivers-for-4.2-kernel.patch \
	file://0001-TBS-fixes-for-4.2-kernel.patch \
	file://0001-STV-Add-PLS-support.patch \
	file://0001-STV-Add-SNR-Signal-report-parameters.patch \
	file://blindscan2.patch \
	file://0001-stv090x-optimized-TS-sync-control.patch \
	file://0003-log2-give-up-on-gcc-constant-optimizations.patch \
	file://0004-cp1emu-do-not-use-bools-for-arithmetic.patch \
	file://dvbskyt330_si2168_demod.patch \
	"

S = "${WORKDIR}/linux-${PV}"
B = "${WORKDIR}/build"

export OS = "Linux"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_OUTPUT = "vmlinux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_IMAGEDEST = "tmp"

KERNEL_EXTRA_ARGS = "EXTRA_CFLAGS=-Wno-attribute-alias"

FILES_${KERNEL_PACKAGE_NAME}-image = "/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz"

kernel_do_install_append() {
    ${STRIP} ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
    gzip -9c ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION} > ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
    rm ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}
}

pkg_postinst_${KERNEL_PACKAGE_NAME}-image () {
    if [ "x$D" == "x" ]; then
        if [ -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz ] ; then
            flash_erase /dev/${MTD_KERNEL} 0 0
            nandwrite -p /dev/${MTD_KERNEL} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
            rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        fi
    fi
    true
}

do_rm_work() {
}

# extra tasks
addtask kernel_link_images after do_compile before do_install
