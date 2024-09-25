require conf/machine/include/dags-oem.inc

DISTRO_FEATURES_remove += "directfb gtk-directfb"

KERNEL_FILE = "oe_kernel.bin"
ROOTFS_FILE = "rootfs.tar.bz2"
MTD_BLACK  = "mmcblk0"

TARGET_ARCH = "arm"
DEFAULTTUNE = "cortexa15hf-neon-vfpv4"
IMAGE_FSTYPES += "tar.bz2"

require conf/machine/include/tune-cortexa15.inc

IMAGE_CMD_tar_prepend = "\
	mkdir -p ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}; \
	cp ${DEPLOY_DIR_IMAGE}/${MACHINE}_initrd_run.bin ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/initrd_run.bin; \
	cp ${DEPLOY_DIR_IMAGE}/zImage ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE}; \
	echo ${IMAGE_NAME} > ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/imageversion; \
	cd ${IMAGE_ROOTFS}; \
	tar -cvf ${DEPLOY_DIR_IMAGE}/rootfs.tar -C ${IMAGE_ROOTFS} .; \
	mv ${DEPLOY_DIR_IMAGE}/rootfs.tar ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/rootfs.tar; \
	bzip2 ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/rootfs.tar; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.zip; \
	cd ${DEPLOY_DIR_IMAGE}; \
	zip ${IMAGE_NAME}_usb.zip ${IMAGEDIR}/*; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.tar.bz2; \
	rm -Rf update; \
	"

IMAGE_CMD_tar_prepend = " \
	rm -Rf ${IMAGE_ROOTFS}/tmp/*; \
	"

EXTRA_IMAGEDEPENDS += "\
	dags-initrd-cfe-${MACHINE} \
	"
